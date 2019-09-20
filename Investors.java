

/*CLASS: Investor...


 REMARKS: What is the purpose of this class?

-----------------------------------------
*/
public class Investors {
    private String name ;
    private String userId;
    private int cash;
    private Portfolior port;

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public int getCash() {
        return cash;
    }

    public Investors(String name, String userId, int cash) {
        this.name = name;
        this.userId = userId;
        this.cash = cash;
        port= new Portfolior(userId);
    }

    @Override
    public String toString() {
        return "Investors{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", cash=" + cash +
                ", port=" + port +
                '}';
    }

    public void portfoliorReport (){
        System.out.println("Name: " + name + " , userId :" + userId  + ",cash on hand :" + cash + " . "+ "" +
                " \n\t Currency Owned :" +
                port.printPortfolior() );
        //System.out.println(port.printPortfolior());

    }

    // method to add  a particluar amount  of cryptocurrency to an investors portfolior
    public void addtoPortfoliior (CryptoCurrency curr, int amount  ){
        port.addToPortfolior(curr,amount );
    }


    // this method reduces the amount of a cryptocurrency in the investors portfolio
    public void subFromPortfolior( CryptoCurrency curr , int amount ){
        port.subFromPortfolio(curr,amount);
    }

    //this method return a boolean if the Investors id are the same , it takes in any object and if the object is an investor it
    //checks if the investors id is the same as the calling investor and it could also take  a userid and compare it directly
    public boolean equals (Object name){
        boolean ret = false ;
        if(name instanceof  Investors){
            Investors investor  = (Investors) name ;
            if (this.userId.equals(investor.userId)){
                ret= true ;
            }
        }
        else if ( name instanceof String){
            if (this.userId.equals(name)){
                ret= true ;
            }
        }
        return ret ;
    }

    public Portfolior getPort() {
        return port;
    }

    public LinkedList allCrpto(){
        return port.getAllcrypto();
    }
}
