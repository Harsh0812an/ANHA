# Sequence Validator – ANHA

## Overview
The Sequence Validator is a Java-based bioinformatics module of **ANHA** designed to check whether input DNA sequences contain only valid DNA nucleotides.

It helps ensure that DNA sequences are valid before they are processed by other ANHA modules, such as DNA Analyzer, Sequence Alignment, and Mutation Finder.

## Features
- Accepts two DNA sequences through manual terminal input.
- Converts input sequences to uppercase.
- Checks whether sequences contain only valid DNA nucleotides.
- Recognizes the four standard DNA bases: `A`, `T`, `G`, and `C`.
- Helps identify invalid characters in DNA input.

## Validation Rules
A DNA sequence is considered valid by this module when it contains only the following characters:

| Nucleotide | Meaning |
|---|---|
| `A` | Adenine |
| `T` | Thymine |
| `G` | Guanine |
| `C` | Cytosine |

Characters other than `A`, `T`, `G`, and `C` are treated as invalid under the current validation rules.

## Technologies Used
- Java
- String Manipulation
- Conditional Statements
- Loops
- Console Input/Output

## How to Run
1. Ensure Java is installed on your system.
2. Download or clone the ANHA repository.
3. Open a terminal in the folder containing `Sequence_Validator.java`.
4. Compile the program:

   ```bash
   javac Sequence_Validator.java
   ```

5. Run the program:

   ```bash
   java Sequence_Validator
   ```

## Current Limitations
- DNA sequences are entered manually through the terminal.
- FASTA file input is planned for a future update.
- The module currently focuses on basic DNA sequence validation.
- Integration with other ANHA modules is planned for future development.

## Future Improvements
- Improve error messages to identify invalid characters and their positions.
- Add FASTA file input support.
- Allow other ANHA modules to reuse the validation logic.
- Integrate sequence validation into the ANHA Main Menu and other relevant modules.

## Part of ANHA
**ANHA** is a Java-based bioinformatics toolkit focused on developing terminal-based tools for DNA sequence analysis and genetic data processing.

The Sequence Validator is intended to help maintain valid DNA input across the toolkit as the project develops.
