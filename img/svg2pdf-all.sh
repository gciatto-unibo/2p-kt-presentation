for f in `ls *.svg`; do
  inkscape --without-gui --export-pdf=${f%.svg}.pdf $f
done
