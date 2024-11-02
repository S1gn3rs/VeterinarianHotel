PO_UILIB_DIR=/usr/share/java
#PO_UILIB_DIR=../../po-uilib
JARNAME=hva-app

all:
	(cd src; javac -cp $(PO_UILIB_DIR)/po-uilib.jar:../../hva-core/hva-core.jar -encoding UTF-8 `find . -name \*.java`)
	(cd src; jar cf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java` )

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
