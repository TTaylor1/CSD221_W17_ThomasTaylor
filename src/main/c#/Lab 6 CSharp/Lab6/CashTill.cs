using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6
{
    public class CashTill
    {
        private Double runningTotal;

        CashTill()
        {
            runningTotal = 0;
        }

        public void sellItem(SaleableItem pPub, String Pub)
        {
            runningTotal = runningTotal + pPub.getPrice();
            Console.WriteLine("Sold " + pPub + " @ " + pPub.getPrice() + "\nSubTotal = " + runningTotal);
        }

        public void showTotal()
        {
            Console.WriteLine("Grand Total:" + runningTotal);
        }
    }
}
