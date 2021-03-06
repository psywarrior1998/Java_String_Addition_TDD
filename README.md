# Java_String_Addition_TDD
**It adds numbers in a string**
It is done using TDD based on the instructions of [TDD KATA-1](https://osherove.com/tdd-kata-1)
-------
- [X] Create a simple String calculator with a method signature:

**int Add(string numbers)**
-------
- [X] The method can take up to two numbers, separated by commas, and will return their sum. 
for example “” or “1” or “1,2” as inputs.(for an empty string it will return 0) 
Hints:
 - [X] Start with the simplest test case of an empty string and move to one and two numbers
 - [X] Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
 - [X] Remember to refactor after each passing test
 ![Test case With No Inputs](/timg/Testing_For_Empty_Input.png)
 ![Test case With Single Input](/timg/Testing_For_Single_Input.png)
 ![Test case With Two Inputs](/timg/Testing_For_Two_Inputs.png)
 ![Test case With Non comma seperator](/timg/Testing_For_Inputs_Not_Seperated_by_commas.png)
-------
- [X] Allow the Add method to handle an unknown amount of numbers
 ![Test case With More than two inputs](/timg/Testing_For_More_Than_Two_Inputs.png)
-------
- [X] Allow the Add method to handle new lines between numbers (instead of commas).
 - the following input is ok: “1\n2,3” (will equal 6)
 ![Test case With newline as A Delim](/timg/Testing_For_NewLine_As_A_Delim.png)
 - the following input is NOT ok: “1,\n” (not need to prove it - just clarifying)
 ![Test case With Single Input And A Delim](/timg/Testing_For_Single_Input_With_A_Delim.png)
-------
- [X] Support different delimiters
 - to change a delimiter, the beginning of the string will contain a separate line that looks like this: “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
 - the first line is optional. all existing scenarios should still be supported
 ![Test case with Custom Delimiters](/timg/Testing_For_Custom_Delim.png)
-------
- [X] Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed. 
 - if there are multiple negatives, show all of them in the exception message.
 ![Test case with negative Numbers in the sequence](/timg/Testing_For_No_Negative_Numbers_Allowed_and_Ignore_them.png)
-------
- [X] Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
 ![Test case With numbers above 1000](/timg/Testing_For_Ignoring_Above_Thousand.png)
-------
- [X] Delimiters can be of any length with the following format: “//[delimiter]\n” for example: “//\[\*\*\*\]\n1\*\*\*2\*\*\*3” should return 6
 ![Test case With Delimiters of any length](/timg/Testing_For_Delimiter_with_any_length.png)
-------
- [X] Allow multiple delimiters like this: “//\[delim1]\[delim2]\n” for example “//\[\*\]\[%\]\n1\*2%3” should return 6.
 ![Test case With Multiple Single Charecter Delimiters](/timg/Testing_For_Multiple_Custom_Delim.png)
-------
- [X] Make sure you can also handle multiple delimiters with length longer than one char
 ![Test case With Multiple Multi Charecter Delimiters](/timg/Testing_For_Multiple_muticharecter_Custom_Delim.png)