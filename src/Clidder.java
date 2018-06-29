class Clidder
{
    String name;

     protected static void flipper()
    {
        System.out.println("Clidder");
    }

    Clidder(){
        System.out.println("in parent");
    }
}

 class Clidlet extends Clidder
{
    public static void flipper()
    {
        System.out.println("Clidlet");
    }
    public static void main(String[] args)
    {
        Clidder clidder=new Clidlet();
        clidder.flipper();
       // new Clidlet().flipper();

        //Clidder clid1=new Clidder("lipi");
       // Clidder clidder=new Clidlet();
        //clidder.hello();
        //clidder.flipper();
        //Clidder.flipper();
    }
}