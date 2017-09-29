package spinal.tester

import spinal.core._
import spinal.lib._


object PlayDebug{


//  class TopLevel extends Component {
//    val sel = in UInt(4 bits)
//    val x = Reg(Bits(8 bits))
//    val y = (Bits(8 bits))
//
//    switch(sel){
//      is(0){
//        x := 1
//        y := 3
//      }
//      is(1){
//        x := 2
//      }
//    }
//
//    when(sel === 3){
//      x := 5
//      y := 6
//    }
//
//    when(BufferCC(sel(0))){
//      x := 87
//    }
//  }


//  class TopLevel extends Component {
//    val buffer = new BufferCC(Bits(8 bits),false, 2)
//  }

//  class TopLevel extends Component {
//    val a,b = in Bits(32 bits)
//    assert(a === b, "miaou")
//    val x = RegNext(a)
//  }

  class TopLevel extends Component {
    val a = in Bits(32 bits)
    val enable = in Bool()
    val x = ClockDomain(ClockDomain.current.clock,ClockDomain.current.reset,clockEnable = enable)(BufferCC(a))
  }


  def main(args: Array[String]) {
    val toplevel = SpinalVhdl(new TopLevel()).toplevel

  }
}