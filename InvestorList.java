

/*CLASS: InvestorList...


 REMARKS: The invsteors list is to store all the investors that have been created


-----------------------------------------
*/
public class InvestorList extends LinkedList {
    private LinkedList allInvestor ;
    public InvestorList () {
        allInvestor = new LinkedList();
    }

   public void insert(Investors c ) {
       if (allInvestor.search(c)== null ){

           allInvestor.insert(c);
           System.out.println("Sucess ( new Investor created ) ");
       }
       else {
           System.out.println("Duplivate Investor ");
       }
   }


    /*********************************************************************
     *  search
     * PURPOSE:The method searches through the allinvestor list and return an investor if it in the list - alllist
     *          if that investor is found it returns an  true
     * PARARMETER : The method takes in a Investor
     * RETURN : The method returns true  if the Investir  was found and false if  not found
     *
     *********************************************************************/
   public boolean search  ( Investors investor  ){
        boolean ret  = false;
        if (allInvestor.search(investor) != null){
            ret = true ;
        }
        return ret;
   }


    /*********************************************************************
     *  searchInvestor
     * PURPOSE:The method searches through the customerportfolir  using the investor userId , if an investor
     *          is found then it would return the investor
     * PARARMETER : The method takes in a String userId
     * RETURN : The method returns an Investor  if its found and null if not fund
     *
     *********************************************************************/

    public Investors searchInvestor ( String userId ){
        Investors ret = null ;
        if (allInvestor.search(userId)!= null ){

            Investors dd  = (Investors) allInvestor.search(userId);
            ret = dd ;
        }
        return ret ;
    }
    public Investors getInvestor (String userId ){
        return searchInvestor(userId);
    }
    public void print1 (){
        System.out.println( allInvestor.print());
    }
}
