# DNA Analyzer

## Description

The **DNA Analyzer** is the first core module of the **ANHA** (Advanced Nucleotide Heuristic Analyzer) project. It performs fundamental analysis on a DNA sequence by validating nucleotide input, calculating sequence statistics, identifying biological characteristics, and generating a comprehensive analysis report.

This module serves as the foundation for the subsequent components of ANHA, including Sequence Alignment and Mutation Detection.

## Features

* Manual DNA sequence input
* DNA sequence validation
* Sequence length calculation
* Nucleotide frequency analysis (A, T, G, C)
* GC Content calculation
* AT Content calculation
* Reverse Complement generation
* Motif detection
* Text-based report generation

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* File Handling
* String Manipulation
* Algorithms
* Bioinformatics Concepts

## How to Run

### Compile

```bash
javac DNA_Analyzer.java
```

### Execute

```bash
java DNA_Analyzer
```

## Sample Output

```text
DNA Analyzer Report
---------------------------
Chosen DNA Strand : ATGCAGTCAGTCGTACGACT

Sequence Length : 21
A : 6
T : 5
G : 6
C : 4

GC Content : 47.62%
AT Content : 52.38%

Reverse Complement :
AGTCGTACGACTGACTGCAT

Motif Analysis :
...
```

## Future Improvements

* FASTA (.fasta) file support
* Additional motif libraries
* Enhanced biological statistics
* Improved validation
* Integration with other ANHA modules

## Part of ANHA

The DNA Analyzer is the first module of the **ANHA** project and provides the core functionality upon which future modules such as **Sequence Alignment** and **Mutation Detection** are built.

## Author

**Harshit Srivastava**
