/*CLASS: CryptoList...


 REMARKS: This class stores the list of all the cryptocurrencies created  in a linkedlist

-----------------------------------------
*/
public class CryptoList extends LinkedList {
    private LinkedList   alist ;// stores all cryptocurency created
    public CryptoList() {
        alist= new LinkedList();
    }


    /*********************************************************************
     *  insert
     * PURPOSE:The method searches throughthe alist  if  the cryptocurrency curr has not  been created ,
     * PARARMETER : The method takes in a cryptocurrency
     * RETURN : void
     *
     *********************************************************************/

    public void insert ( CryptoCurrency curr ){
        if ( alist.search(curr ) == null ){// search if

            alist.insert(curr);
            System.out.println("Success(new Cryptocurrency created )");

        }
        else {
            System.out.println("Duplicate Cryptocurrency!");;
        }

    }



    /*********************************************************************
     *  getCrpto
     * PURPOSE:The method searches throughthe the list of all crptocurrencie that has been created.
     *          if that object is found or returns null if not found
     * PARARMETER : The method takes in a STring symbol
     * RETURN : The method returns a Cryptocurrency if  found and null if not found
     *
     *********************************************************************/

    public CryptoCurrency getCrpto (String Symbol ){
        CryptoCurrency ret = null;
        if ( alist.search(Symbol)!=null) {

             ret = (CryptoCurrency) alist.search(Symbol);
        }
      return ret ;
    }




}
