using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6
{
    public abstract class Publication : SaleableItem
    {
        private String title;
        private Double price;
        private int copies;

        public String Title
        {
            get { return title; }
            set { this.title = value; }
        }

        public Double Price
        {
            get { return price; }
            set { price = value; }
        }

        public int Copies
        {
            get { return copies; }
            set { copies = value; }
        }

        public String getTitle() { return title; }

        public void setTitle(String title) { this.title = title; }

        public int getCopies() { return copies; }

        public void setCopies(int copies) { this.copies = copies; }

        public Double getPrice() { return price; }

        public void setPrice(Double price) { this.price = price; }

        public Publication()
        {
            this.copies = Copies;
            this.price = Price;
            this.title = Title;
        }

        override public String ToString()
        {
            return "Title: " + Title +
                "\nPrice: " + "$" + Price +
                "\nCopies: " + Copies;
        }

        public void sellCopy()
        {
            Console.WriteLine("Sell Copy");
        }

    }
}
