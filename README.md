# XMLTreeExpressionEvaluator
NaturalNumber and Int Implementation


A lightweight Java utility that evaluates arithmetic expressions structured in XML format. It supports both int and arbitrary-size NaturalNumber implementations, and reads XML input files to compute the result of nested expressions.

Implements:
- Parses XML trees containing arithmetic expressions (plus, minus, times, divide)
- Recursively evaluates each expression node from the XML structure
- Accepts input from XML files and outputs the final computed result
- Provides two versions of the evaluator:
- XMLTreeIntExpressionEvaluator: uses Java primitive int
- XMLTreeNNExpressionEvaluator: uses NaturalNumber for arbitrary-size values

Run By:Java
Input/Output: SimpleReader and SimpleWriter components

Concepts
- Recursive evaluation of tree-based arithmetic expressions
- Defensive programming (e.g., divide-by-zero error handling)
- Use of abstract data types (NaturalNumber)
- File-based input/output and XML interpretation

To Run:
- Compile the Java files (XMLTreeIntExpressionEvaluator.java, XMLTreeNNExpressionEvaluator.java)
- Prepare an XML file containing a well-formed arithmetic expression
- Run the program and enter the filename when prompted
- The console will display the evaluated result
