public class Cutlery 
{
    private Object fork, knife;

    public Cutlery () {
	fork = new Object();
	knife = new Object();
    }

    public Object getFork() {
	return fork;
    }

    public Object getKnife() {
	return knife;
    }    
}
