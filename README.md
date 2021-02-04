###Design Pattern

###Design Pattern Nedir?
>Tasarım kalıpları, yazılım geliştiricilerin yazılım geliştirme sırasında karşılaştıkları genel sorunların çözümüdür. 

Tasarım kalıpları, test edilmiş ve kanıtlanmış geliştirme imkanları sağlayarak geliştirme sürecini hızlandırabilir. Etkili yazılım tasarımı, uygulamanın ilerleyen zamanlarına kadar görünmeyebilecek sorunları dikkate almayı gerektirir. Tasarım kalıplarının yeniden kullanılması, büyük sorunlara neden olabilecek küçük sorunların önlenmesine yardımcı olur ve kalıplara aşina olan kodlayıcılar ve mimarlar için kod okunabilirliğini artırır.

Çoğu zaman, insanlar sadece belirli yazılım tasarım tekniklerinin belirli sorunlara nasıl uygulanacağını anlarlar. Bu tekniklerin çok çeşitli sorunlara uygulanması zordur. Tasarım modelleri, belirli bir soruna bağlı özellikler gerektirmeyen bir biçimde belgelenmiş genel çözümler sunar.

Buna ek olarak, kalıplar geliştiricilerin yazılım etkileşimleri için iyi bilinen, iyi anlaşılan isimler kullanarak iletişim kurmalarını sağlar. Yaygın tasarım desenleri zaman içinde geliştirilebilir. Bu da onları geçici tasarımlardan daha sağlam hale getirir.

Tasarım kalıpları;
* Creational Design Patterns (Yaratıcı)
* Structural Design Patterns (Yapısal)
* Behavioral Design Patterns (Davranışsal)

olmak üzere 3'e ayrılır.

##Creational Design Patterns (Yaratıcı)
Bu tasarım kalıpları tamamen sınıf örneklemesi ile ilgilidir. Bu örüntü ayrıca sınıf yaratma örüntülerine ve nesne yaratma örüntülerine ayrılabilir. Sınıf yaratma kalıpları örnekleme sürecinde kalıtımı etkin bir şekilde kullanırken, nesne oluşturma kalıpları işi yapmak için delegasyonu etkin bir şekilde kullanır.

Abstract Factory : Birkaç sınıf ailesinin bir örneğini oluşturur.

Builder : Nesne yapısını temsilinden ayırır.

Factory Method : Birkaç türetilmiş sınıfın örneğini oluşturur.

Object Pool : Artık kullanılmayan nesneleri geri dönüştürerek pahalı kaynaklardan kurtulmak ve kaynakları serbest bırakmak için kullanılır.

Prototype : Kopyalanacak veya klonlanacak tamamen başlatılmış bir örnek oluşturur.

Singleton : Yalnızca tek bir örneği var olabilecek bir sınıf.

##Structural Design Patterns (Yapısal)
Bu tasarım kalıpları tamamen Sınıf ve Nesne kompozisyonuyla ilgilidir. Yapısal sınıf yaratma kalıpları, arayüz oluşturmak için kalıtım kullanır. Yapısal nesne kalıpları, yeni işlevsellik elde etmek için nesne oluşturma yollarını tanımlar.

Adapter : Farklı sınıfların eşleme arayüzleri.

Bridge : Bir nesnenin arayüzünü uygulamasından ayırır.

Composite : Basit ve kompozit nesnelerin ağaç yapısı.

Decorator : Nesnelere dinamik olarak sorumluluk ekleme.

Facade : Bütün bir alt sistemi temsil eden tek bir sınıf.

Flyweight : Verimli paylaşım için kullanılan bir örnek.

Private Class Data : Erişimi kısıtlar.

Proxy : Başka bir nesneyi temsil eden nesne. 


##Behavioral Design Patterns (Davranışsal)

Bu tasarım kalıpları tamamen Class'ın nesne iletişimi ile ilgilidir. Davranışsal örüntüler, nesneler arasındaki iletişim ile en özel olarak ilgili örüntülerdir.

Chain of responsibility : Bir nesne zinciri arasında istek iletmenin bir yolu.

Command : Bir komut isteğini nesne olarak kapsülleme.

Interpreter : Bir programa dil öğelerini dahil etmenin bir yolu.

Iterator : Bir koleksiyonun öğelerine sırayla erişin.

Mediator : Sınıflar arasındaki basitleştirilmiş iletişimi tanımlar.

Memento : Bir nesnenin dahili durumunu yakalama ve geri yükleme.

Null Object : Bir nesnenin varsayılan değeri olarak çalışmak üzere tasarlanmıştır.

Observer : Bazı sınıflardaki değişikliği bildirmenin bir yolu.

State : Bir nesnenin durumu değiştiğinde davranışını değiştirme.

Strategy : Sınıf içindeki bir algoritmayı içine alır.

Template method : Bir algoritmanın tam adımlarını bir alt sınıfa erteleme.

Visitor : Değişiklik olmadan bir sınıfa yeni bir işlem tanımlar.

###Singleton Design Pattern
>Singleton desgin pattern çalışma zamanında yalnızca 1 object yaratılmasını garanti eden tasarım desenidir.

Kullanımına ihtiyaç duyulan durum şudur :
* Birden çok sınıfın aynı instance’ı kullanması gerekmektedir.
* Tüm uygulama için yalnızca bir nesne olması gerekmektedir.
* Sadece bir nesne olduğu (unique) garanti edilmelidir.

Bu gereklilikler için bir sınıf yaratırız ve sınıfın kendi instance’ını yönetmesini sağlarız.

*Singleton Design Pattern kendi içinde 5'ya ayrılır.

####1.Eager Initialization
Bu yapı bize bir tane instance yaratmayı garanti eder fakat ihtiyacımız olmadıgı durumlarda bile program çalıştıgı an bellekte yer kaplayacaktır.

    public class EagerInitializationSingleton {
    	
    	private static final EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();
    	
    	private EagerInitializationSingleton() {
    		
    	}
    	
    	public static EagerInitializationSingleton getInstance() {
    		return INSTANCE;
    	}
    	public void singletonTest() {
    		System.out.println("Eager Singleton method calisti");
    	}

####2.Lazy Initialization

Bu yapıyı kullandığımız zaman başlangıçta bir instance yaratmaz ve bellekte yer kaplamaz. Fakat her çağırıldıgında null check yapmak zorunda kalır. 
* Birden fazla thread erişmeye çalışırsa lag oluşturabilir veya runtime exception oluşturabilir. 
* Multi thread işlem yapmıyorsak en kolay ve en iyi yöntem olabilir.

       
       private static LazySingleton lazySingleton;
       	
       	private LazySingleton() {
       		
       	}
       	
       	public static LazySingleton getLazySingleton() {
       		if(lazySingleton==null) {
       			lazySingleton= new LazySingleton();
       		
       		}
       		return lazySingleton;
       	}
       	
       	public void singletonTest() {
       		System.out.println("Lazy Singleton method calisti");
       	}
       	
####3.Static Block Initialization
Eager Initialization’un yapısına benzer. Tek farkı burada exception handling yapılmasına olarak sağlar.
    
      public class StaticBlockSingleton {
      	
      	private static StaticBlockSingleton staticBlockSingleton;
      	
      	static {
      		 try {
      			 staticBlockSingleton= new StaticBlockSingleton();
      		} catch (Exception e) {
      			
      		}
      	}
      	
      	private StaticBlockSingleton() {
      		
      	}
      	public static StaticBlockSingleton getStaticBlockSingleton() {
      		return staticBlockSingleton;
      	}
      	
      	public void singletonTest() {
      		System.out.println("Static Block Singleton method calisti");
      	}
      	
####4.Thread Safe Singleton
Lazy initialization yapısı gibi çalışır fakat syncronized oldugu için işlemleri sıraya koyar.Bu sayede multi thread çalışmaya izin verir.
Her seferinde check işlemi yaparken bir performans kaybı olur 

    public class ThreadSafeSingleton {
    	
    	private static ThreadSafeSingleton threadSafeSingleton;
    	
    	private ThreadSafeSingleton() {
    		
    	}
    	
    	public static synchronized ThreadSafeSingleton getThreadSafeSingleton() {
    		if(threadSafeSingleton==null) {
    			threadSafeSingleton=new ThreadSafeSingleton();
    		}
    		return threadSafeSingleton;
    	}
    	public void singletonTest() {
    		System.out.println("ThreadSafe Singleton method calisti");
    	}
      	
      	
####5.Bill Pugh Singleton 
Yükleme süresi thread safe yapısından kısadır. Direk olarak static bir degişken tanımlamadıgımız için jwm bunu hemen load etmeyecektir.
   
    public class BillPughSingleton {
    	private BillPughSingleton() {
    		
    	}
    	
    	public static final BillPughSingleton getInstance(){
    		
    		return SingletonHelper.INSTANCE;
    		
    	}
    	
    	private static class SingletonHelper{
    		private static final BillPughSingleton INSTANCE= new BillPughSingleton();
    		
    		
    		
    	}
    	public void singletonTest() {
    		System.out.println("Bill Pugh Singleton method calisti");
    	}
    	
###Prototype Design Pattern
>Prototype Pattern kullanılmasının amacı üretilen nesnenin çok kaynak tüketmesi durumunun engellenmesini sağlamaktır.

Yaptığımız projemizde nesnemizi birden fazla oluşturmamız gerektiğinde normalde “new” olarak oluşturmak yerine bir tane oluşturduğumuz nesnemizin klonunu oluşturmamızı sağlayan bir design patterndir.

Prototype tasarım deseninde 3 temel yapı vardır. Bunlar:
* Soyut prototip: Kopyalanarak kullanılmak istenen nesneler için temel oluşturacak, içinde kopyalama işlemi için özet bir metot bulunduran abstract class’tır. Bu yapı interface veya abstract class olabilir. İhtiyaca göre hangisinin olacağına karar verilir.
* Somut prototip: Uygulamada, kopyalanması istenen gerçek nesnelerdir. Bu nesneler, soyut prototipte var olan özet metodun extends edilmesiyle (kalıtımıyla) kopyalanırlar.
* Client Uygulama: Somut prototip nesnelerinden birer eleman elde edecek olan sınıf, metot veya bir elemandır.    	
         	
Bu pattern yapısını daha iyi anlamak için aşağıda bulunan kodu inceleyebilirsiniz.

Shape sınıfı aşağıdaki gibidir. Cloneable ile, sınıfımızı klonlanabilir özelliğe kavuşturulur. Klonlama aşamasında Object sınıfının clone() metodu kullanılır. 

    public abstract class Shape implements Cloneable {
    
    	private String id;
    	protected String type;
    
    	abstract void draw();
    
    	public Object clone() {
    		Object clone = null;
    
    		try {
    			clone = super.clone();
    		} catch (CloneNotSupportedException e) {
    			e.printStackTrace();
    		}
    		return clone;
    	}
    
    	public String getId() {
    		return id;
    	}
    
    	public void setId(String id) {
    		this.id = id;
    	}
    
    	public String getType() {
    		return type;
    	}
    
    	public void setType(String type) {
    		this.type = type;
    	}
    }   
    
Bu soyut sınıfı extends eden (kalıtım alan) Rectangle, Square ve Circle sınıfları aşağıdaki gibidir.       	
 
Circle

    public class Circle extends Shape {
    	@Override
    	void draw() {
    		System.out.println("Inside Circle::draw() method.");
    	}
    
    	public Circle() {
    		type = "Circle";
    	}
    }
    
 Rectange
 
    public class Rectangle extends Shape{
    	@Override
    	void draw() {
    		System.out.println("Inside Rectangle::draw() method.");
    	}
    
    	public Rectangle() {
    		type = "Rectangle";
    	}
    }
    
Square

    public class Square extends Shape {
    	@Override
    	void draw() {
    		System.out.println("Inside Square::draw() method.");
    	}
    
    	public Square() {
    		type = "Square";
    	}
    }   
   
 Bu sınıflara ait nesnelerin tek sefer de load edilerek kopyalanması ve istendiğinde kullanılabilmesi için, bir Cache sınıfı(ShapeCache) oluşturulur.
 
    public class ShapeCache {
    
    	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();
    
    	public static Shape getShape(String id) {
    		Shape cachedShape = shapeMap.get(id);
    		return (Shape) cachedShape.clone();
    	}
    
    	public static void loadCache() {
    		Circle circle = new Circle();
    		circle.setId("1");
    		shapeMap.put(circle.getId(),circle);
    
    		Square square = new Square();
    		square.setId("2");
    		shapeMap.put(square.getId(),square);
    
    		Rectangle rectangle = new Rectangle();
    		rectangle.setId("3");
    		shapeMap.put(rectangle.getId(), rectangle);
    	}
    }
    
Burada artık loadCache methodu kullanarak ShapeCache üzerinden tüm nesneleri tek seferde yaratmamıza olanak sağlar.
Bundan sonra load edilen tüm nesneleri, id değerini belirtme şartıyla kullanılabilir.

###Adapter Design Pattern

>Mevcut bir sınıfın arayüzünün başka bir arayüz olarak kullanılmasına izin veren bir yazılım tasarım modelidir.

Kullanım amacı;
* İki uyumsuz interface’i beraber kullanılmasını sağlar.
* Daha önce yazılmış olan kodları düzenlemek gerekmez.
* Uygulama herhangi bir yerde değişiklik yapmak gerekmez.    

Bu pattern yapısını daha iyi anlamak için aşağıda bulunan kodu inceleyebilirsiniz.  

Crypt interface yazılımın şifreleme için halihazırda kullandığı yapıdır.

    public interface Crypt {
    
    	public void encrypt(String text);
    
    	public void decrypt(String text);
    }
    
Bu interface kullanarak CryptA ve CryptB sınıfları oluşturulmuştur.

CryptA
    
     public class CryptA implements Crypt {
     
         public void encrypt(String text) {
     
             System.out.println("#CryptA#encrypt()");
         }
     
         public void decrypt(String text) {
     
             System.out.println("#CryptA#decrypt()");
         }
     }

CryptB

    public class CryptB implements Crypt {
    
        public void encrypt(String text) {
    
            System.out.println("#CryptB#encrypt()");
        }
    
        public void decrypt(String text) {
    
            System.out.println("#CryptB#decrypt()");
        }
    }
    
Aşağıda bulunan CodeX sınıfı Crypt interfacesi kullanarak implement edilmediği için mehtodları farklıdır.

    public class CodeX {
    
        public void textToCode(String text) {
    
            System.out.println("#CodeX#textToCode()");
        }
    
        public void codeToText(String text) {
    
            System.out.println("#CodeX#codeToText()");
        }
    }
    
Bu sınıfı CryptA ve CryptB gibi kullanmak için bu sınıfın Adapter sınıfı yazılır. Bu sınıf Crypt interfacesini implement edeceği için artık CryptA ve CryptB gibi kullanılabilecektir.

    public class CodeXAdapter implements Crypt {
    
        private CodeX codeX;
    
        public CodeXAdapter(CodeX codeX){
    
            this.codeX = codeX;
        }
    
        public void encrypt(String text) {
    
            codeX.textToCode(text);
        }
    
        public void decrypt(String text) {
    
            codeX.codeToText(text);
        }
    }

###Facade Design Pattern

Facade Design Pattern örnek olarak bir kütüphane geliştiricisi bir sistem geliştirilirken o kütüphaneyi kullanan yazılımcıya kolaylık sağlamak ve kod kalabalıgını azaltmak için arka planda yapılan işlemleri yazılımcıya bir method yardımıyla dogrudan verir.

Bu pattern yapısını daha iyi anlamak için aşağıda bulunan kodu inceleyebilirsiniz.  

Aşağıda ki AESEncryptor MD5Encryptor ve SHAEncryptor sınıfları bir şifreleme kütüphanesinin sınıfları olduğunu varsayalım.

AESEncryptor

    public class AESEncryptor {
    	  public void encrypt(String text) {
    	        System.out.println("<AES>" + text + "</AES>");
    	    }
    }

MD5Encryptor

    public class MD5Encryptor {
    	  public void encrypt(String text, String key) {
    	        System.out.println("<MD5>" + text + key + "</MD5>");
    	    }
    }


SHAEncryptor

    public class SHAEncryptor {
    	public void encrypt(String text, String key, boolean type) {
    		if (type)
    			System.out.println("<SHA>" + text + key + "</SHA>");
    		else
    			System.out.println("<SHA>" + key + text + "</SHA>");
    	}
    
    }

Yazılımcı bu sınıfları tek tek bilmek ve tek tek instance yaratmasını engellemek için bir EncryptorFacade sınıfı oluşturulur. Bu sınıftan altında bulunan şifreleme sınıflarına doğrudan erişim sağlanır.

    public class EncryptorFacade {
    
    
        private AESEncryptor aesEncryptor = new AESEncryptor();
        private MD5Encryptor md5Encryptor = new MD5Encryptor();
        private SHAEncryptor shaEncryptor= new SHAEncryptor();
    
        public void encrypt(String text, EncType encType) {
            switch (encType) {
                case AES: aesEncryptor.encrypt(text); break;
                case MD5: md5Encryptor.encrypt(text, "KEY"); break;
                case SHA:shaEncryptor.encrypt(text, "KEY", true); break;
                default: throw new IllegalArgumentException(encType.toString());
            }
        }
    
        public enum EncType {
            SHA,
            MD5,
            AES
        }
    }
 
###Factory Design Pattern  

Factory Design Pattern aynı tipteki nesnelerin üretmeyi tek bir noktadan yaparak kod tekrarını engeller.
Aynı zamanda kullanacak olan yazılımcılar işin arkasındaki kısımları bilmeden gerekli parametreleri vererek doğrudan o sınıflara erişmeden kullanabilirler.

Bu pattern yapısını daha iyi anlamak için aşağıda bulunan kodu inceleyebilirsiniz. 

Aşağıda bulunan FileExporter interfacesi Export işlemi yapıcak olan sınıflar için gerekleri methodları içinde bulundurur.

    public interface FileExporter {
    	String export(String content);
    	
    }

PdfExporter ve ExcelExporter sınıfları FileExporter interfacesini implement eden Export işlemi yapan sınıflardır.

PdfExporter

    class PdfExporter implements FileExporter{
    	public String export(String content) {
    		return "PDF -> "+ content;
    	}
    }

ExcelExporter

    class ExcelExporter implements FileExporter{
    	
    	public String export(String content) {
    		return "EXCEL -> "+ content;
    	}
    }
    
Aşağıda bulunan FileExporterFactory sınıfı ise içine verilen parametreye göre Export sınıflarına erişmeye gerek kalmadan doğrudan kullanılmasını sağlar
    
    public class FileExporterFactory {
    	public static FileExporter getInstance(FileType fileType) {
    		switch(fileType) {
    		case EXCEL: return new ExcelExporter();
    		case PDF: return new PdfExporter();
    		default: throw new UnsupportedOperationException();
    		
    		}
    	}
    	
    	public enum FileType{
    		PDF,
    		EXCEL;
    	}
    }
   


###Observer Design Pattern  
>Observer tasarım deseni, bir nesnede meydana gelen değişikliği içinde bulunduğu listedeki tüm elemanlara bildiren tasarım desenidir.

Bir nesnenin durumunun değişmesi ile o nesneye bağlı diğer nesnelerin bu değişimi bilmesi isteniyorsa, böyle durumlarda bu tasarım desenini kullanılabilir.

Observer Design Pattern kullanılabilmesi için Observer ve Observable interface sınıflarına ihtiyaç vardır.

* Observer: Değişimden etkilenecek, izleyecek olan sınıfların uyguladığı arayüzdür. Misal Kullanıcı, Abone sinifları
* Observable: Takip edilecek olan yapımızdır. İçerisinde Observer (değişimden etkilenecek) nesneleri tutar. Yazmış olduğumuz sistemin katılım alacağı, gözlemleyici.

Bu pattern yapısını daha iyi anlamak için aşağıda bulunan kodu inceleyebilirsiniz. 

Aşağıda bulunan IAbone interfacesi Değişimden etkilenecek olan Observer interfacesidir.

    public interface IAbone {
    	public void mesajAl(String message);
    }

IMessageSystem interfacesi ise takip edilecek olan Obsevable interfacesidir.
    
    public interface IMessageSystem {
    	
    	 public void addUser(Kullanici kullanici);
    	 public void removeUser(Kullanici kullanici);
    	 public void sendMessage(String message);
    
    }

Kullanıcı sınıfı IAbone interfacesini implement ederek oluşturulmuş bir sınıftır.

    public class Kullanici implements IAbone{
    
    	@Override
    	public void mesajAl(String message) {
    		 System.out.println(message);
    		
    	}
    
    }
    
Sms ve Notification sınıfları ise IMessageSystem interfacesinden implement edilirler. Bu durumda bir bildirim geldiği durumda bu bildirimi mesaj olarak yada sms olarak alabilirler.

Sms
      
     public class Sms implements IMessageSystem{
     	
     	private List<Kullanici> kullanicilar= new ArrayList<Kullanici>();
     
     	@Override
     	public void addUser(Kullanici kullanici) {
             kullanicilar.add(kullanici);
     		
     	}
     
     	@Override
     	public void removeUser(Kullanici kullanici) {
             kullanicilar.remove(kullanici);
     		
     	}
     
     	@Override
     	public void sendMessage(String message) {
     		kullanicilar.forEach(item->{
     			item.mesajAl(message);
     		});
     		
     	}
     
     }
             

Notification

    public class Notification implements IMessageSystem{
    	
    	private List<IAbone> kullanicilar=new ArrayList<IAbone>();
    	
    
    	@Override
    	public void addUser(Kullanici kullanici) {
    		kullanicilar.add(kullanici);
    		
    	}
    
    	@Override
    	public void removeUser(Kullanici kullanici) {
            kullanicilar.remove(kullanici);		
    	}
    
    	@Override
    	public void sendMessage(String message) {
    		kullanicilar.forEach(item->{
    			item.mesajAl(message);
    		});
    		
    	}
    
    }

    

###Template Design Pattern

Bu tasarım şablonunda bir gidişat belirleyebilmek, bir algoritma yapabilmek adına işlemler soyut olarak tanımlanır. Bu işlemler, bir şablon metot tarafından çalıştırılır. Alt sınıflar da bu soyut adımları kendi bünyelerinde implemente ederek kullanılan algoritmanın istekleri doğrultusunda çalışmasını sağlayabilirler.

Aşağıda bulunan örnekte futbol ve kriket sporları için oyunun başlama ve bitme süreçleri template design pattern uygularak anlatılmıştır.

Abstract olan game sınıfı içerisinde başlama ve bitiş methodlarını tutar. Bu sınıftan extend edilerek oluşturulan futbol ve kriket sınıfları ise play methodu üzerinden doğrudan bu methodları kullanabilir.

Game

    public abstract class Game {
    
    	public abstract void initialize();
    	public abstract void startPlay();
    	public abstract void endPlay();
    	
    	public final void play() {
    		initialize();
    		startPlay();
    		endPlay();
    		
    	}
    }

Football

    public class Football extends Game{
    
    	@Override
    	public void initialize() {
    		System.out.println("Football game initialized!");
    		
    	}
    
    	@Override
    	public void startPlay() {
    		System.out.println("Football game started!");
    		
    	}
    
    	@Override
    	public void endPlay() {
    		System.out.println("Football game ended!");
    		
    	}
    }

Criket

    public class Cricket extends Game{
    	
    	@Override
    	public void initialize() {
    		System.out.println("Cricket game initialized!");
    		
    	}
    
    	@Override
    	public void startPlay() {
    		System.out.println("Cricket game started!");
    		
    	}
    
    	@Override
    	public void endPlay() {
    		System.out.println("Cricket game ended!");
    		
    	}
    
    }




 

        

  



     


     
                   

Kaynaklar
* https://blog.kmk.net.tr/design-patterns-nedir
* https://medium.com/i%CC%87yi-programlama/singleton-design-pattern-nedir-6f9ab8ea2e32
* https://medium.com/@yasinmemic/prototype-design-pattern-nedir-37dc82983bef
* https://metinalniacik.medium.com/adapter-design-pattern-tasar%C4%B1m-%C3%B6r%C3%BCnt%C3%BCs%C3%BC-3469833059d9
* https://github.com/HaydiKodlayalim/java-design-patterns
* https://umiitkose.com/2020/05/observer-pattern-nedir/
