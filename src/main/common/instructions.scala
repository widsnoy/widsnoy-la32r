package common

import chisel3.util._

/* 
support instructions:
    1. add.w
    2. sub.w
    3. slt
    4. sltu
    5. nor
    6. and
    7. or
    8. xor
    9. slli.w
    10. srli.w
    11. srai.w
    12. addi.w
    13. ld.w
    14. st.w
    15. jirl
    16. b
    17. bl
    18. beq
    19. bne
    20. lu12i.w
    21. slti
    22. sltui
    23. andi
    24. ori
    25. xori
    26. sll.w
    27. srl.w
    28. sra.w
    29. pcaddu12i
    30. mul.w
    31. mulh.w
    32. mulh.wu
    33. div.w
    34. mod.w
    35. div.wu
    36. mod.wu
 */

object Instructions {
    val add_w       = BitPat("b00000000000100000???????????????")
    val sub_w       = BitPat("b00000000000100010???????????????")
    val slt         = BitPat("b00000000000100100???????????????")
    val sltu        = BitPat("b00000000000100101???????????????")
    val nor         = BitPat("b00000000000101000???????????????")
    val and         = BitPat("b00000000000101001???????????????")
    val or          = BitPat("b00000000000101010???????????????")
    val xor         = BitPat("b00000000000101011???????????????")
    val slli_w      = BitPat("b00000000010000001???????????????")
    val srli_w      = BitPat("b00000000010001001???????????????")
    val srai_w      = BitPat("b00000000010010001???????????????")
    val addi_w      = BitPat("b0000001010??????????????????????")
    val ld_w        = BitPat("b0010100010??????????????????????")
    val st_w        = BitPat("b0010100110??????????????????????")
    val jirl        = BitPat("b010011??????????????????????????")
    val inst_b      = BitPat("b010100??????????????????????????")
    val inst_bl     = BitPat("b010101??????????????????????????")
    val beq         = BitPat("b010110??????????????????????????")
    val bne         = BitPat("b010111??????????????????????????")
    val lu12i_w     = BitPat("b0001010?????????????????????????")
    val slti        = BitPat("b0000001000??????????????????????")
    val sltui       = BitPat("b0000001001??????????????????????")
    val andi        = BitPat("b0000001101??????????????????????")
    val ori         = BitPat("b0000001110??????????????????????")
    val xori        = BitPat("b0000001111??????????????????????")
    val sll_w       = BitPat("b00000000000101110???????????????")
    val srl_w       = BitPat("b00000000000101111???????????????")
    val sra_w       = BitPat("b00000000000110000???????????????")
    val pcaddu12i   = BitPat("b0001110?????????????????????????")
    val mul_w       = BitPat("b00000000000111000???????????????")
    val mulh_w      = BitPat("b00000000000111001???????????????")
    val mulh_wu     = BitPat("b00000000000111010???????????????")
    val div_w       = BitPat("b00000000001000000???????????????")
    val mod_w       = BitPat("b00000000001000001???????????????")
    val div_wu      = BitPat("b00000000001000010???????????????")
    val mod_wu      = BitPat("b00000000001000011???????????????")
    val blt         = BitPat("b011000??????????????????????????")
    val bge         = BitPat("b011001??????????????????????????")
    val bltu        = BitPat("b011010??????????????????????????")
    val bgeu        = BitPat("b011011??????????????????????????")
    val ld_b        = BitPat("b0010100000??????????????????????")
    val ld_h        = BitPat("b0010100001??????????????????????")
    val st_b        = BitPat("b0010100100??????????????????????")
    val st_h        = BitPat("b0010100101??????????????????????")
    val ld_bu       = BitPat("b0010101000??????????????????????")
    val ld_hu       = BitPat("b0010101001??????????????????????")
}