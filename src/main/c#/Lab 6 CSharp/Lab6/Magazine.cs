using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6
{
    public class Magazine : Publication
    {

        private int orderQty;
        private string currIssue;

        

        public Magazine()
        {

            this.orderQty = 0;
            this.currIssue = "n/a";
        }

        public int OrderQty
        {
            get { return orderQty; }
            set { this.orderQty = value; }
        }

        public string CurrIssue
        {
            get { return currIssue; }
            set { this.currIssue = value; }
        }

        public override string ToString()
        {
            return base.ToString() + "\nQuantity Ordered: " + orderQty + "\nDate of Current Issue: " + currIssue;
        }
    }
}
