# Aho-Corasick Algorithm

## Description
This project implements Aho-Corasick in Java and compares it with KMP.

## Project Structure
- Main.java - runs the tests
- AhoCorasick.java - implements Aho-Corasick
- KMP.java - implements KMP

## Testing
- Patterns: 10, 100, 1000
- Text sizes: 1000, 10000, 100000
- Each test runs 5 times
- Time measured using System.nanoTime()

## Results

| Patterns | Text | Aho (ms) | KMP (ms) |
|---|---|---|---|
| 10 | 1000 | 0.895 | 1.362 |
| 10 | 10000 | 2.155 | 4.444 |
| 10 | 100000 | 2.845 | 6.986 |
| 100 | 1000 | 0.416 | 0.713 |
| 100 | 10000 | 0.534 | 7.089 |
| 100 | 100000 | 2.382 | 64.987 |
| 1000 | 1000 | 1.779 | 6.092 |
| 1000 | 10000 | 0.922 | 58.840 |
| 1000 | 100000 | 3.200 | 564.488 |

## How to Run
java Main

## Conclusion
Aho-Corasick is faster for multiple patterns.
KMP is simpler for searching one pattern.