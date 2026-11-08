# Protein Translator – ANHA

## Overview
The Protein Translator is a Java-based bioinformatics module of **ANHA** designed to translate a DNA sequence into its corresponding protein sequence.

The module first converts DNA into messenger RNA (mRNA) through transcription and then translates mRNA codons into amino acids using the standard genetic code.

## Features
- Accepts DNA sequences through manual terminal input.
- Converts DNA input to uppercase.
- Validates DNA sequences using the four standard nucleotides: `A`, `T`, `G`, and `C`.
- Performs DNA-to-mRNA transcription by replacing `T` with `U`.
- Divides mRNA into codons consisting of three nucleotides.
- Translates codons into their corresponding amino acids.
- Recognizes stop codons: `UAA`, `UAG`, and `UGA`.
- Stops translation upon encountering the first stop codon.
- Displays the resulting protein sequence.
- Calculates the protein sequence length.
- Displays the stop codon encountered during translation.

## Biological Concepts

### Transcription
DNA is converted into messenger RNA (mRNA). In RNA, Uracil (`U`) replaces Thymine (`T`).

### Codons
A codon is a sequence of three nucleotides in mRNA that specifies an amino acid or a translation signal.

### Translation
The process through which mRNA codons are decoded into a sequence of amino acids, forming a protein.

### Stop Codons
The three standard stop codons are:

| Stop Codon | Function |
|---|---|
| `UAA` | Terminates translation |
| `UAG` | Terminates translation |
| `UGA` | Terminates translation |

## Technologies Used
- Java
- String Manipulation
- Switch Statements
- Loops
- Conditional Statements
- Console Input/Output

## How to Run
1. Ensure Java is installed on your system.
2. Download or clone the ANHA repository.
3. Open a terminal in the folder containing `ProteinTranslator.java`.
4. Compile the program:

   ```bash
   javac ProteinTranslator.java
   ```

5. Run the program:

   ```bash
   java ProteinTranslator
   ```

## Current Limitations
- DNA sequences are entered manually through the terminal.
- Translation begins from the first nucleotide of the input sequence.
- Automatic start-codon searching is not implemented.
- Multiple reading-frame translation is not implemented.
- Incomplete codons at the end of the sequence are ignored.
- Translation stops at the first recognized stop codon.

## Future Improvements
- Add FASTA file input support.
- Integrate with the ANHA ORF Finder module.
- Support translation of different reading frames.
- Improve protein sequence analysis and reporting.
- Add additional protein-related analysis tools.

## Part of ANHA
**ANHA** is a Java-based bioinformatics toolkit focused on developing terminal-based tools for DNA sequence analysis and genetic data processing.

Protein Translator is a Phase 2 module of ANHA.
