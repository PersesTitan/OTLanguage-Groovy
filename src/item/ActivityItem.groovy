package item

import print.Print
import print.Println
import print.ScannerP

interface ActivityItem {
    ScannerP scannerP = new ScannerP()
    Print print = new Print()
    Println println = new Println()
}