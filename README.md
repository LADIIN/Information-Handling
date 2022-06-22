# Information-Handling
Goal:
  Create an application that parses text from a file and allows you to perform three different operations on the text.
  
Requirements:
  - The parsed text should be represented as an object containing, for example, paragraphs, sentences, tokens, words, expressions, symbols. A lexeme is a part of the text     bounded by whitespace characters. Use Composite to organize the data structure.
  - Information classes are entity classes and should not be overloaded with logic methods.
  - The source text is always correct. That is, all sentences begin with a capital letter and end with ".", "?", "!" or "...". All paragraphs begin with a tab character or a given number of spaces, e.g. 4 spaces.
  - The disassembled text must be restored to its original form. Spaces and tabs can be replaced with a single space.
  - You should use regular expressions to divide the text into its components. Keep in mind that regular expressions are literal constants for the application.
  - The code that performs text parsing should be designed as parser classes using the Chain of Responsibility.
  - When developing parsers which parse text, you must keep track of the number of parser objects you create. There should not be too many of them.
  - Bit expressions occurring in the text must be computed. And the final text (data structure) must contain the calculated value. Use Interpreter using functional interfaces.
  - To record the logs use Log4J2.
  - The created application must allow to implement a group of tasks to work on the text (tasks are listed below) without "rewriting" the existing code.
  - The code must be covered by tests.
  - The class with the main method in the task must be absent. Run using tests only.
