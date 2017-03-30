using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab6
{
    public class Book : Publication
    {
        private String author;

        public void orderCopies(int copies) { setCopies(copies); }

        // properties
        public String Author
        {
            get { return author; }
            set { this.author = value; }
        }

        public Book()
        {
            author = "Me";
            setCopies(5);
        }

        public override string ToString()
        {
            return base.ToString() + "\nAuthor: " + author;
        }
    }
}
