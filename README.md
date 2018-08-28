# DNA-Calculator
DNA-Calculator reads a character string and performs basic computation on four characters: 'A', 'C', 'G', 'T'.
These characters represent the four nucleobases found in DNA: Adenine, Cytosine, Guanine, and Thymine. 
When provided with the input string of characters, the DNA-Profiler will calculate the sum of each nucleobase, their relative percentages, and the largest consecutive number of each one (case is ignored). Characters other than the above are counted separately and their relative percentages are calculated as well.  

## Getting Started
These instructions explain how to run the DNA-Calculator on a Windows machine, running the program from Eclipse.

###### Download DNA-Calculator or clone the repo to your local machine. 
Import DNA-Calculator into your workbench:

1. Click the File menu and select *import*
2. Select the *File System* folder and click next 
3. Browse file system to select the local repo and select finish

###### Running the program with an input file
1. DNA-calculator can read the character data from an input file. To do this from Eclipse, select "Run" from
the toolbar and then select "Run Configurations" from the dropdown. In the text box labeled "Program arguments: " type in the
relative path name of your input file. 
2. Open source file tree and find/select the analysis package.
3. R-click Analyzer.java and select *Run as Java program*
4. The program prints the quantities, percentages, and largest consecutive number of each nucleobase.

## Running the program from the command line

1. Remove all arguments from the run configurations.
2. Follow the steps above to run the program from Eclipse.
3. DNA-Calculator will prompt for a string of input. Input a string of text and return. DNA-Calculator will stop when it comes to a whitespace.
4. The program prints quantities, percentages, and largest consecutive number of nucleobase.


## Development & Technology
GRSManager is developed using JRE 1.8.0 in Eclipse.

## Cited Resources
- Building Java Programs - Reges & Stepp
- Java Platform, SE 7, 8, API

### Todos

