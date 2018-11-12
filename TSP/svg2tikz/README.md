# svg2tikz

Very simple parser from svg to tikz. This parser is meant for converting a map (corresponding to a path) and the cities (corresponding to circle) in tikz in order to use it in notes related to the activity.

## Usage

  `java -jar "svg2tikz.jar" filename [output]`
  
  with `filename` the name of the svg file and `output` the output filename. If no output is specified, the output will be written in `filename.tex`
