/*CLASS: PortFoliorList...


 REMARKS: The class stores an a cryptocurrency and the amount  of that cryptocurreny that  an investor has

-----------------------------------------
*/


public class InvestorCrypto extends LinkedList {
    private int amount ;
    private CryptoCurrency cry ;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }




    public InvestorCrypto(CryptoCurrency v, int amount ) {
        cry=v;
       this. amount=amount;


    }



    /*********************************************************************
     *  equals
     *
     * PURPOSE:  The equals method is to compare the cryptocurrency(Cry ) and Object(curr)
     *          (if the object is aalso a cryptocurency ) that is passed in the method
     *    - thhe methos
     * PARARMETER : The method takes in a an Object
     * RETURN : The method returns a n boolean indicating  if the cryptocurrency is equals to the Object passed in
     *
     *********************************************************************/

    public boolean  equals  (Object curr )

    {
        boolean ret = false ;
        if (curr instanceof  CryptoCurrency)
        {
            //cast the Object into a cryptocurrency
            CryptoCurrency acrytpo = (CryptoCurrency) curr ;

            // compare if the currencies are equal using the equals method un cryptocurrency (polymorphism )
            ret = this.cry.equals(acrytpo);

        }
        return ret ;
    }


    public String toString () {
        return   cry.getName() + " ,amount : " + amount ;
    }


    // this method is to reduce the quantity  of a cryptocurrency . it is assumed that the currecny is present


}
