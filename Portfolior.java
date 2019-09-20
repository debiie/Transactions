
/*CLASS: Portfolio...


 REMARKS: The portfolior class stores the list of all currencies and amount of owned  by an investor

-----------------------------------------
*/
public class Portfolior {
    private LinkedList customerPortfolior ;
    private LinkedList allcrypto ;// a list of the cryptocurrencies in the portfolooir
    private String userId;
    public Portfolior (String userId){
        this.userId= userId;
        customerPortfolior = new LinkedList();
        allcrypto = new LinkedList();
    }

    public LinkedList getAllcrypto() {
        return allcrypto;
    }
    /*********************************************************************
     *  addToPortfolior
     *
     * PURPOSE: The addTopotfolior method is to to add a cryptocurrency and the amount an investor has (InvestorCrypto)
                into the the list  customerportfolio if the the crypocurrency is not already there. If the cryptocurrency and amount is already present in
                the list then the method adds the new amount into the already existing amount that the  InvestorCrypto already has :
     * PARARMETER : The method takes in a cryptocurrency and an amount
     * RETURN : Void
     *
     *********************************************************************/

    public void addToPortfolior(CryptoCurrency cryto, int amount  ){
        // check if the customer portfolior does not  already has a cryptocurrency  crypto
        if (customerPortfolior.search(cryto)==null){
            // cast the crypto
            InvestorCrypto pf = new InvestorCrypto(cryto,amount);
            customerPortfolior.insert(pf );
            allcrypto.insert(cryto);
        }

        // if the customerportfolior  dhas the cryptocurrency then add the new amount to it
        else {
            if (customerPortfolior.search(cryto) instanceof InvestorCrypto){
                InvestorCrypto c = (InvestorCrypto) customerPortfolior.search(cryto );
               c.setAmount(c.getAmount() + amount );
            }
        }

    }


    /*********************************************************************
     *  subFromPortfolior
     *
     * PURPOSE: The method is to search throughh the customer porfolior for a InvestorCrupto(crptocurrency and amount )
     *          and subtract the parameter amount  from the amount present in the InvestorCrypto with the cryptocurrency;
     *          if present
     * PARARMETER : The method takes in a cryptocurrencyand an amount
     * RETURN : Void
     *
     *********************************************************************/



    public void subFromPortfolio ( CryptoCurrency curr , int amount ){
        if ( customerPortfolior.search(curr )!= null ){
            if (customerPortfolior.search(curr) instanceof InvestorCrypto){
                InvestorCrypto c = (InvestorCrypto) customerPortfolior.search(curr );
                c.setAmount(c.getAmount() - amount );
            }
        }

    }


    @Override
    public String toString() {
        return "Portfolior{" +
                  customerPortfolior.print() +
                '}';
    }

    //method to a users protfolior record
    /*********************************************************************
     *  PrintPortfolir
     *
     * PURPOSE: The methos printPorfolior is to print out all the Cryptocurrencies and amount (InvestorCrypto),
     *          an investpr has in the customerPortfolior
     * PARARMETER : No parameter
     * RETURN : The method returns a string of all the Cryptocurrencies and amount  an investpr has
     *
     *********************************************************************/

    public String  printPortfolior () {
        return  customerPortfolior.print();


    }


    /*********************************************************************
     *  search
     * PURPOSE:The method searches throughthe customerportfolir if a Investcrypto of the cryptocurrency curr has already been created ,
     *          if that object is found or returns null if not found
     *          currency is present and return the cryptocurrency and the amount ( InvestorCrypto)
     * PARARMETER : The method takes in a cryptocurrency
     * RETURN : The method returns an InvestorCrypto Object if the Cryptocurrency was found and nullif not found
     *
     *********************************************************************/

    public InvestorCrypto search (CryptoCurrency curr ) {
        InvestorCrypto hj = null ;
        if ( curr != null ){
             hj = (InvestorCrypto) customerPortfolior.search(curr);

        }
        return hj ;
    }

}
