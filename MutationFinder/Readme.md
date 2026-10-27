# Mutation Finder – ANHA

## Overview
The Mutation Finder is a Java-based bioinformatics module of **ANHA** designed to compare two DNA sequences and identify possible mutations using sequence alignment.

It uses the Needleman–Wunsch global alignment algorithm to align the sequences before analyzing differences between them.

## Features
- Accepts two DNA sequences through manual console input.
- Converts input sequences to uppercase.
- Performs global sequence alignment using the Needleman–Wunsch algorithm.
- Identifies and counts:
  - **Substitutions** – one nucleotide replaced by another.
  - **Insertions** – additional nucleotides in one sequence relative to the other.
  - **Deletions** – nucleotides missing relative to the other sequence.
- Counts matching positions.
- Calculates sequence similarity and mutation rate.
- Displays a mutation analysis report in the terminal.
- Includes timestamp and file-handling support for report generation.

## Algorithm
The module uses the **Needleman–Wunsch algorithm**, a dynamic programming method for global sequence alignment.

Current scoring system:
- Match: `+1`
- Mismatch: `-1`
- Gap: `-2`

These scores help determine the alignment between the two DNA sequences.

## Technologies Used
- Java
- Dynamic Programming
- String Manipulation
- Console Input/Output
- File Handling

## How to Run
1. Ensure Java is installed on your system.
2. Download or clone the ANHA repository.
3. Open a terminal in the folder containing `Mutation_finder.java`.
4. Compile the program:

   ```bash
   javac Mutation_finder.java
   ```

5. Run the program:

   ```bash
   java Mutation_finder
   ```

## Current Limitations
- DNA sequences are entered manually through the terminal.
- FASTA file input is planned for a future update.
- Mutation analysis depends on the alignment produced by the algorithm.
- The
