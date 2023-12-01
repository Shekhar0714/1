// The adapter pattern convert the interface of a class into another interface clients expect.
//  Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces
interface JSONData
{
    void readJSONData();
}
class JSONSoftware implements JSONData
{
    public void readJSONData()
    {
        System.out.println("Understand only JSON data");
    }
}

interface XMLData
{
    void readXMLData();
}
class XMLSoftware implements XMLData
{
    public void readXMLData()
    {
        System.out.println("Understand only XML data");
    }
}
class XMLToJSONDataAdapter implements JSONData
{
    XMLData xmldata;
    XMLToJSONDataAdapter(XMLData xmldata)
    {
        this.xmldata=xmldata;
    }
    public void readJSONData()
    {
        xmldata.readXMLData();
        System.out.println("Convert XML data to JSON data");
    }
}
public class Adapter
{
    public static void main(String args[])
    {
        XMLSoftware xmlSoft=new XMLSoftware();
        JSONData xmlAdapter=new XMLToJSONDataAdapter(xmlSoft);
        xmlAdapter.readJSONData();
    }
}