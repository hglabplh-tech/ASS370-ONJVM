(ns hgp.ass370.compile.370-bin.map_to_370_CPU_Code
  (:require [hgp.ass370.compile.370-bin.internal-inst-forms :refer :all]))

;; From Material of International Business Machines Corporation

;;One of the major design decisions undertaken by computer architects is the choice of formats
;for the binary machine language instructions. The basic question revolves around the length
;of the instruction. Should all instructions have the same length, or should a variety of
;instruction lengths be allowed. This question is essentially a trade–off between complexity
;of the control unit and efficient use of memory space.
;More bluntly, the big issue is the cost of random access memory for a computer. In the early
;1960’s, memory was quite expensive. As an example, consider that a fully equipped NCR
;mainframe, shipped in 1966, had only 256 KB of memory, which cost $100,000
;
;
;
;($400, 000
;       per megabyte) . As late as 1979, memory cost was $75, 000 per megabyte. As a result, a
;small System / 3 60 might ship with only 16 KB to 64 KB installed. Within that context, the
;design emphasis was on an instruction set that made the most efficient use of memory.
;For this reason, the S / 3 60 instruction set provides for instruction lengths of 2 bytes, 4 bytes,
;and 6 bytes. This resulted in six instruction classes, each with an encoding scheme that
;allowed the maximum amount of information to be specified in a small number of bytes.
;These formats are classified by length in bytes, use of the base registers, and object code
;format. The five instruction classes of use to the general user are listed below.
;Format Length Use
;Name in bytes
;RR 2 Register to register transfers.
;RS 4 Register to storage and register from storage
;RX 4 Register to indexed storage and register from indexed storage
;SI 4 Storage immediate
;SS 6 Storage–to–Storage. These have two variants,
;each of which we shall discuss soon.
;Before we launch on a formal description of these formats, it might be helpful to give some
;informal comments. We begin by noting that the opcode (machine code representation) of
;each instruction has a length of exactly one byte. With 8 bits to represent the opcode, this
;allows for 256 different operations, more if an extra encoding scheme is used.
;Consider the register–to–register instructions. Since there are only 16 registers, each register
;can be fully specified by a 4–bit hexadecimal digit, and one byte will suffice to specify the
;two registers. Thus, the specification of one operation and two registers would require only 2
;bytes. For this reason, the type RR instructions are encoded into two bytes of memory.
;Consider now the mechanism used to specify an address. It calls for a base register
;(encoded
;  in 4 bits) and a 12–bit address offset (encoded in 12 bits), for a total of 16 bits or two bytes.
;Given that the operation must specify a source or destination register, the sum grows to 20
;bits. With the addition of an 8–bit opcode, the total grows to 28 bits, or 3.5 bytes. As
;fractional bytes cannot be accommodated in memory, the total is increased to four bytes and
;the instruction expanded to include two registers. The encoding is then 8 bits for the opcode,
;8 bits for two source/destination registers, and 16 bits for the address: 4 bytes in all.
;S / 3 70 Assembler Language Instruction Formats
;Page 162 Chapter 9 Revised June 28, 2009
;Copyright © 2009 by Edward L. Bosworth, Ph.D.
;Branch Instructions
;One of the encodings used to minimize the instruction size is to use the idea of a condition
;mask to extend two basic branch instructions into fourteen equivalent branch instructions.
;This device is often called “syntactic sugar” or extended mnemonics. There are two basic
;branch instructions in the IBM instruction set.
;BC MASK, TARGET A TYPE RX INSTRUCTON
;BCR MASK, REGISTER A TYPE RR INSTRUCTION
;In the Type RX instruction, the target address is computed using the base register and
;displacement method, with an optional index register: D2 (X2, B2) . In the Type RR
;instruction, the target address is found as the contents of the register.
;Each of these instruction formats uses a four–bit mask, with bit numbers based on the 2–bit
;value of the condition code in the PSW, to determine the conditions under which the branch
;will be taken. The mask should be considered as having bits numbered left to right as 0 – 3.
;Bit 0 is the equal/zero bit. Bit 2 is the high/plus bit.
;Bit 1 is the low/minus bit. Bit 3 is the overflow bit.
;The Standard Combinations
;The following table shows the standard conditional branch instructions and their translation
;to the BC (Branch on Condition) . The same table applies to BCR
;(Branch on Condition,
;        Register), so that there is another complete set of mnemonics for that set.
;Bit Mask Flags Condition Extended instructions
;0 1 2 3 Sort Arithmetic
;0 0 0 0 No branch BC 0, XX NOP
;0 0 0 1 Bit 3: Overflow BC 1, XX BO XX
;0 0 1 0 Bit 2: High/Plus BC 2, XX BH XX BP
;0 1 0 0 Bit 1: Low/Minus BC 4, XX BL XX BM
;0 1 1 1 1, 2, 3: Not Equal BC 7, XX BNE XX BNZ
;1 0 0 0 Bit 0: Equal/Zero BC 8, XX BE XX BZ
;1 0 1 1 0, 2, 3: Not Low BC 11.XX BNL XX BNM
;1 1 0 1 0, 1, 3: Not high BC 13, XX BNH XX BNP
;1 1 1 1 0, 1, 2, 3: Any BC 15, XX B XX
;Note the two sets of extended mnemonics: one for comparisons and an equivalent
;set for the results of arithmetic operations.

;;Author: Harald Glab-Plhak -> translate to real binary format for 390 ESA CPU's

(defn create-rr-form [input-bytes]

  )

(defn create-i-form [input-bytes]

  )