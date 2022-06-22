package item

import print.Print
import print.Println
import print.ScannerP
import variable.BooleanP
import variable.CharacterP
import variable.DoubleP
import variable.FloatP
import variable.IntegerP
import variable.LongP
import variable.StringP

interface ActivityItem {
    ScannerP scannerP = new ScannerP()
    Print print = new Print()
    Println println = new Println()
    /*=================================*/
    BooleanP booleanP = new BooleanP()
    CharacterP characterP = new CharacterP()
    DoubleP doubleP = new DoubleP()
    FloatP floatP = new FloatP()
    IntegerP integerP = new IntegerP()
    LongP longP = new LongP()
    StringP stringP = new StringP()
}