# @todo kiniry 16 Aug 2005 - Remove jmlc_junit seperate compilation
# and classfile directory as it is no longer necessary with JML 5.

RELEASE = v2.0.0
BASE	= proposal
BIBTEXOPT = 
BIBWARN = 'LaTeX Warning: Citation'
REFWARN = 'Rerun to get cross-references'
LATEXMAX = 6
FIGSCALE = 0.5

# CLASSPATH components

CORECP	= src:specs
SPECS = ../../specs
JARS = /usr/local/JML/bin
JMLCP	= $(JARS)/jmlruntime.jar:$(JARS)/jmljunitruntime.jar:$(JARS)/jml-release.jar:$(SPECS)
JUNITCP	= $(JARS)/junit.jar
#CHECKSTYLECP	= $(JARS)/checkstyle-optional-4.3.jar:$(JARS)/checkstyle-all-4.3.jar
#ESCJAVA2CP = $(JARS)/esctools2.jar

# local variables for build process

jml ?= /usr/local/bin/jml
javac ?= /usr/bin/javac
jmlrac ?= /usr/local/bin/jmlrac
jmlc ?= /usr/local/bin/jmlc
jmldoc ?= /usr/local/bin/jmldoc
jmlunit ?= /usr/local/bin/jmlunit

basedocdir = doc
srcpath = src
specpath =$(SPECS)
buildpath =	build
jmlc_path =	jmlc_build
jmlunit_path =	jmlunit_build
jmlc_jmlunit_path =	jmlc_jmlunit_build

#ESCPATH = ../../../ESCJava2
#escjava = $(ESCPATH)/Escjava/escj -source 1.4 -vclimit 2500000
#export ESCTOOLS_ROOT=$(ESCPATH)
#export SIMPLIFY=$(ESCPATH)/Escjava/release/master/bin/Simplify-1.5.4.macosx

# Various CLASSPATH constructions

BASE_CLASSPATH	= $(CORECP):$(JCECP):$(FOPCP):$(MISCCP):$(JUNITCP):$(JMLCP)
JAVAC_CLASSPATH	= $(buildpath):$(BASE_CLASSPATH)
JMLC_CLASSPATH	= $(jmlc_path):$(BASE_CLASSPATH)
JUNIT_CLASSPATH	= $(jmlc_jmlunit_path):$(BASE_CLASSPATH)
#ESCJAVA_CLASSPATH	= $(CORECP):$(JCECP):$(FOPCP):$(MISCCP):$(JUNITCP):$(JMLCP):$(ESCJAVA2CP)
UNIT_TEST_CLASSPATH	= $(jmlc_jmlunit_path):$(buildpath):$(JUNITCP):$(JMLCP)
#CHECKSTYLE_CLASSPATH	= $(CORECP):$(CHECKSTYLECP)

javapat	=	$(srcpath)/election/tally/*.java
javafiles =	$(wildcard $(srcpath)/election/tally/*.java)
jmlunitpat =	$(jmlunit_path)/election/tally/*java
jmlunitfiles =	$(wildcard $(jmlunit_path)/election/tally/*.java)
generated_jmlunitfiles	=	$(wildcard $(jmlunit_path)/election/tally/*_JML_Test.java)
classfiles =	$(foreach javafile,$(javafiles),\
		$(subst .java,.class,$(javafile)))
javadocflags =	-version -author -private -source 1.5
jmldocflags =	-version -author -private --source 1.5
javadocdir =	$(basedocdir)/javadocs
jmldocdir =	$(basedocdir)/jmldocs

main_memory_use =	-ms256M -mx256M
rac_memory_use =	-ms256M -mx320M
test_memory_use	=	-ms256M -mx320M

copyright = "Votail<br />&copy; 2006-9 Systems Research Group and University College Dublin<br />All Rights Reserved"

# implicit rules for paper documentation generation

%.ps: %.gif
	giftopnm $< | pnmtops -noturn > $@
%.ps: %.fig
	fig2dev -L ps $< > $@
%.eps: %.fig
	fig2dev -L eps $< > $@
%.pdf: %.fig
	fig2dev -L pdf $< > $@
%.pdf: %.eps
	epstopdf $< > $@
.pdf_t: %.pstex_t
	sed 's/\.pstex/\.pdf/g' $< > $@
%.pdftex: %.tex
	sed 's/\.pstex_t/\.pdf_t/g' $< > $@
%.pstex: %.fig
	fig2dev -L pstex -m $(FIGSCALE) $< > $@
%.pstex_t: %.fig
	fig2dev -L pstex_t -m $(FIGSCALE) -p `basename $< .fig`.pstex $< > $@
%.ps: %.dvi
	dvips -D600 -Ppdf $< -o $@

%.aux: %.tex
	latex $*

%.dvi: %.tex
	latex $<
	if grep $(BIBWARN) $*.log >/dev/null; \
	then bibtex $(BIBTEXOPT) $*; latex $<; latex $<; fi
	RUNS=$(LATEXMAX); \
	while [ $$RUNS -gt 0 ] ; do \
		if grep $(REFWARN) $*.log > /dev/null; \
		then latex $< ; else break; fi; \
		RUNS=`expr $$RUNS - 1`; \
	done

%.pdf: %.ps
	ps2pdf $<

# identification of phony targets

.PHONY: all build escjava test ps pdf spellcheck \
	classes jmlc jmlc_jmlunit jmlunit jmlunit_classes \
	escjava2-typecheck escjava2 escjava2-current escjava2-core \
	main main-jmlrac jml-junit-tests jmlrac-tests \
	source_docs javadoc jmldoc checkstyle \
	clean clean_other_stamps clean_classes clean_jmlc \
	clean_jmlcjunit clean_jmlunit \
	clean_javadoc clean_jmldoc

# targets

all:	build source_docs test distr

build:	classes jml jmlc jmlunit_classes

#escjava:	escjava2-typecheck escjava2

test:	jmlrac-tests

# paper documentation-related

ps:	$(BASE).ps

$(BASE).dvi:	$(BASE).tex\
		$(BASE).bbl

$(BASE).bbl:	$(BASE).aux\
		$(BASE).bib
		bibtex $(BIBTEXOPT) $(BASE)

$(BASE).ps:		$(BASE).dvi

$(BASE).pdf:	$(BASE).ps
		ps2pdf13 $(BASE).ps

pdf:		$(BASE).pdf

ps:		$(BASE).ps

spellcheck:
		aspell --lang=american --master=american -t -c $(BASE).tex
#aspell --lang=british --master=british -t -c $(BASE).tex

# targets related to building software

classes:	classes.stamp

classes.stamp:	$(javafiles)
	@mkdir -p $(buildpath)
	export CLASSPATH=$(JAVAC_CLASSPATH);\
	$(javac) -g -d $(buildpath) -source 1.4 $(javapat) && \
	touch classes.stamp

jml:	jml.stamp

jml.stamp:	$(javafiles)
	export CLASSPATH=$(JMLC_CLASSPATH);\
	$(jml) --Quiet --source 1.4 -A -a $(javapat) && \
	touch jml.stamp

jmlc:	jmlc.stamp

jmlc.stamp:	$(javafiles)
	@mkdir -p $(jmlc_path)
	export CLASSPATH=$(JMLC_CLASSPATH);\
	$(jmlc) --destination $(jmlc_path) \
		--Quiet --source 1.4 -A -a $(javapat) && \
	touch jmlc.stamp

jmlc_jmlunit: jmlc_jmlunit.stamp

jmlc_jmlunit.stamp:	$(javafiles)
	@mkdir -p $(jmlc_jmlunit_path)
	export CLASSPATH=$(JUNIT_CLASSPATH);\
	$(jmlc) --destination $(jmlc_jmlunit_path) \
		--Quiet --source 1.4 -A -a $(javapat) && \
	touch jmlc_jmlunit.stamp

jmlunit:	jmlc_jmlunit jmlunit.stamp

jmlunit.stamp:	$(javafiles)
	@mkdir -p $(jmlunit_path)
	export CLASSPATH=$(JAVAC_CLASSPATH);\
	$(jmlunit) --destination $(jmlunit_path) \
		--sourcepath $(specpath):$(srcpath) \
		--package --source 1.4 \
		--testLevel=2 $(srcpath)/election/tally && \
	touch jmlunit.stamp

jmlunit_classes:	jmlunit jmlunit_classes.stamp

jmlunit_classes.stamp:	$(jmlunitfiles)
	mkdir -p $(jmlc_jmlunit_path)
	export CLASSPATH=$(JUNIT_CLASSPATH);\
	javac -g -d $(jmlc_jmlunit_path) -source 1.4 $(jmlunitpat) && \
	touch jmlunit_classes.stamp

# targets related to checking software

#escjava2-typecheck:	escjava2-typecheck.stamp
#
#escjava2-typecheck.stamp:	$(javafiles)
#	export CLASSPATH=$(ESCJAVA_CLASSPATH);\
#	$(escjava) -typecheck $(javapat) && \
#	touch escjava2-typecheck.stamp
#
#escjava2:	escjava2.stamp
#
#escjava2.stamp:	$(javafiles)
#	export CLASSPATH=$(ESCJAVA_CLASSPATH);\
#	$(escjava) $(javapat) && \
#	touch escjava2.stamp
#
#escjava2-current:
#	export CLASSPATH=$(ESCJAVA_CLASSPATH);\
#	$(escjava) -bootclasspath $(BOOTCP) \
#		election/tally/BallotCounting.java
#
#escjava2-core:
#	export CLASSPATH=$(ESCJAVA_CLASSPATH);\
#	$(escjava) -bootclasspath $(BOOTCP) \
#		election/tally/BallotCounting.java \
#		election/tally/Ballot.java \
#		election/tally/Candidate.java

#checkstyle.stamp:
#	export CLASSPATH=$(CHECKSTYLE_CLASSPATH); \
#	java com.puppycrawl.tools.checkstyle.Main \
#		-c srg-group.xml $(core_javafiles)
#
#checkstyle:	checkstyle.stamp

# executing the program

main: classes
	export CLASSPATH=$(JAVAC_CLASSPATH);\
	java $(main_memory_use) election.tally.BallotCounting

main-jmlrac: jmlc
	export CLASSPATH=$(JMLC_CLASSPATH);\
	jmlrac $(rac_memory_use) election.tally.BallotCounting

jml-junit-tests:	classes jmlunit_classes
	export CLASSPATH=$(UNIT_TEST_CLASSPATH);\
	jml-junit $(test_memory_use) .election.tally.BallotCounting_JML_Test

jmlrac-tests:	classes jmlunit_classes
	export CLASSPATH=$(UNIT_TEST_CLASSPATH);\
	jmlrac $(test_memory_use) .election.tally.Ballot_JML_Test
	export CLASSPATH=$(UNIT_TEST_CLASSPATH);\
	jmlrac $(test_memory_use) .election.tally.Candidate_JML_Test
	export CLASSPATH=$(UNIT_TEST_CLASSPATH);\
	jmlrac $(test_memory_use) .election.tally.BallotCounting_JML_Test

jmlrac-tests-current:	classes jmlunit_classes
	export CLASSPATH=$(UNIT_TEST_CLASSPATH);\
	jmlrac $(test_memory_use) election.tally.

# generating source-based documentation

source_docs:	javadoc jmldoc

javadoc:	javadoc.stamp

javadoc.stamp:	$(javafiles) $(srcpath)/election/tally/package.html $(basedocdir)/overview.html
	mkdir -p $(javadocdir); \
	export CLASSPATH=$(BASE_CLASSPATH);\
	$(javadoc) -d $(javadocdir) $(javadocflags) \
	-sourcepath .:$(srcpath):$(jdksrcpath) \
	-overview $(basedocdir)/overview.html \
	-doctitle "Votail: ballot counting for the Irish Election System" \
	-header $(copyright) \
	-footer $(copyright) \
	-subpackages election.tally; \
	touch javadoc.stamp

jmldoc:		jmldoc.stamp

jmldoc.stamp:	$(javafiles) $(srcpath)/election/tally/package.html $(basedocdir)/overview.html
	mkdir -p $(jmldocdir); \
	export CLASSPATH=$(BASE_CLASSPATH);\
	$(jmldoc) -d $(jmldocdir) $(jmldocflags) \
	-sourcepath .:$(srcpath):$(jdksrcpath) \
	-overview $(basedocdir)/overview.html \
	-doctitle "Votail: ballot counting for the Irish Election System" \
	-header $(copyright) \
	-footer $(copyright) \
	election.tally;
	touch jmldoc.stamp

distr: distr.stamp

distr.stamp: classes clean_distr
	mkdir -p distr/tmp
	mkdir -p distr/koa
	mkdir -p distr/koa/lib
	mkdir -p distr/koa/doc
	cp -r build/* distr/tmp
	jar -J-Xmx256M -mcf MANIFEST.MF distr/koa/votail.jar -C distr/tmp .
	rm -rf distr/tmp
	cd distr/koa; jar -i votail.jar
	cd distr; zip votail.zip koa/votail.jar
	touch distr.stamp

src_distr: src_distr.stamp 

src_distr.stamp: distr clean_src_distr
	mkdir -p distr/koa/src/election/tally
	mkdir -p distr/koa/doc/javadocs
	mkdir -p distr/koa/doc/jmldocs
	cp src/election/tally/*.java distr/koa/src/sos/koa
	cp src/election/tally/*.html distr/koa/src/sos/koa
	cp -r doc/javadocs/* distr/koa/doc/javadocs
	cp -r doc/jmldocs/* distr/koa/doc/jmldocs
	cp doc/koa.css distr/koa/doc 
	cp doc/overview.html distr/koa/doc 
	cp ChangeLog distr/koa
	cp $(version_file) distr/koa
	cd jars; cp -r src ../distr/koa/lib/
	rm -rf distr/koa/lib/src/CVS
	cat README.header > distr/$(readme_file)
	cd distr; zip -r votail.zip koa/
	cd distr; echo '' >> $(readme_file)
	cd distr; echo 'The binaries:' >> $(readme_file)
	cd distr; echo '----' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'jar' >> $(readme_file)
	cd distr; echo '' >> $(readme_file)
	cd distr; echo 'The documentation:' >> $(readme_file)
	cd distr; echo '----' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'docs' | grep -v 'html' |grep -v 'sos' |grep -v 'package' |grep -v 'resources' | grep -v 'stylesheet' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'pdf' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'package' | grep 'src' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'Change' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'README' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'VERSION' >> $(readme_file)
	cd distr; echo '' >> $(readme_file)
	cd distr; echo 'The sources:' >> $(readme_file)
	cd distr; echo '----' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'src'|grep 'election/tally' |grep -v 'java'|grep -v 'html' >> $(readme_file)
	cd distr; unzip -l votail.zip |grep 'src'|grep 'lib' >> $(readme_file)
	cat README.footer >> distr/$(readme_file)
	cd distr; zip -r votail.zip $(readme_file)
	touch src_distr.stamp

usermanual:	usermanual.stamp

usermanual.stamp:	
	cd $(usermanual_dir); make pdf
	touch usermanual.stamp

# targets related to cleaning up

clean:	clean_javadoc clean_jmldoc clean_classes clean_jml clean_jmlc clean_jmlunit clean_jmlcjunit clean_other_stamps clean_distr clean_src_distr
	rm -f $(BASE).dvi $(BASE).ps $(BASE).pdf
	rm -f *.log *.bbl *.blg *.aux *.out
	rm -f *.pstex *.pstex_t *.pdf *.pdf_t *.pdftex
	rm -f *.bak
clean_other_stamps:
	rm -f escjava2-typecheck.stamp escjava2.stamp checkstyle.stamp

clean_classes:
	rm -rf distr $(buildpath) classes.stamp jmlunit_classes.stamp

clean_jml:
	rm -rf jml.stamp

clean_jmlc:
	rm -rf $(jmlc_path) jmlc.stamp

clean_jmlcjunit:
	rm -rf $(jmlc_jmlunit_path) jmlc_jmlunit.stamp

clean_jmlunit:
	rm -f $(generated_jmlunitfiles) jmlunit.stamp

clean_javadoc:
	rm -rf $(javadocdir)/*.html \
		$(javadocdir)/ie* \
		$(javadocdir)/com* \
		$(javadocdir)/images \
		$(javadocdir)/package-list \
		$(javadocdir)/stylesheet.css \
		javadoc.stamp

clean_jmldoc:
	rm -rf $(jmldocdir)/*.html \
		$(jmldocdir)/ie* \
		$(jmldocdir)/com* \
		$(jmldocdir)/images \
		$(jmldocdir)/package-list \
		$(jmldocdir)/stylesheet.css \
		jmldoc.stamp

clean_distr:
	rm -rf distr

clean_src_distr:
	rm -rf src_distr.stamp