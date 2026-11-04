# ORF Finder – ANHA

## Overview
The ORF Finder is a Java-based bioinformatics module of **ANHA** designed to identify Open Reading Frames (ORFs) within DNA sequences.

An Open Reading Frame is a section of DNA that begins with a start codon and continues until a stop codon is encountered. ORFs are potential protein-coding regions and are useful in genetic sequence analysis.

This module searches DNA sequences to identify potential ORFs and analyze their characteristics.

## Features
- Accepts DNA sequences through manual terminal input.
- Identifies start codons (`ATG`).
- Recognizes stop codons (`TAA`, `TAG`, and `TGA`).
- Searches all six reading frames.
- Analyzes the reverse-complement strand.
- Identifies overlapping ORFs.
- Filters ORFs based on minimum length.
- Ranks identified ORFs according to their length.
- Displays ORF analysis results in the terminal.

## Technologies Used
- Java
- String Manipulation
- Loops and Conditional Statements
- Array Processing
- Bioinformatics Algorithms

## How to Run
1. Ensure Java is installed on your system.
2. Download or clone the ANHA repository.
3. Open a terminal in the folder containing `OrfFinder.java`.
4. Compile the program:

   ```bash
   javac OrfFinder.java
   ```

5. Run the program:

   ```bash
   java OrfFinder
   ```

## Biological Concepts
- **ORF:** A DNA region that may encode a protein.
- **Start Codon:** `ATG`, which generally initiates translation.
- **Stop Codons:** `TAA`, `TAG`, and `TGA`, which signal the end of translation.
- **Reading Frame:** The way a nucleotide sequence is divided into groups of three bases called codons.
- **Reverse Complement:** The complementary DNA sequence written in reverse orientation.

## Current Limitations
- DNA input is currently provided manually through the terminal.
- ORF identification does not confirm whether a region actually produces a functional protein.
- FASTA file input is planned for future development.

## Future Improvements
- Add FASTA file input support.
- Improve ORF analysis and reporting.
- Integrate ORF Finder with other ANHA modules.
- Develop additional sequence-processing capabilities.

## Part of ANHA
**ANHA** is a Java-based bioinformatics toolkit focused on developing terminal-based tools for DNA sequence analysis and genetic data processing.

ORF Finder is part of ANHA's ongoing development.
