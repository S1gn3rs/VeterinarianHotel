all:
	(cd hva-core; make $(MFLAGS) all)
	(cd hva-app; make $(MFLAGS) all)

clean:
	(cd hva-core; make $(MFLAGS) clean)
	(cd hva-app; make $(MFLAGS) clean)

install:
	(cd hva-core; make $(MFLAGS) install)
	(cd hva-app; make $(MFLAGS) install)

