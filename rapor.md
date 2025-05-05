DÜKKAN YÖNETİM SİSTEMİ
 
Beklentiler:
	Küçük (8 masalı) bir kahvaltıcı/şarküteri dükkanının, halihazırda fiziksel araçlarla tutulan satış, maliyet ve ciro hesaplama sistemini dijitalleştirmek ve raporlamalarının yapılmasını sağlamak. Dükkanın mevcut “kaba düzen” sistemini verilere dökülebilir hale getirerek geliştirmek ve karını artırmak hedeflenmektedir. Projenin ilk prototipinin dükkanda test edilerek geliştirilmesi ve ileri aşamalarda kullanıma sokulması planlanmaktadır.

Hedefler:  

	1.Dükkanın satışları perakende kahvaltılık ürünler ve fiks serpme kahvaltı olarak iki kategoriden oluşmaktadır. Serpme kahvaltının içeriği perakende ürünlerden ve yan ürünlerden oluşmaktadır. Mevzubahis ürünlerin kahvaltı içerisinde hangi gramajda sunulduğu bellidir. Yönetici, ürünlerin perakende satıştaki fiyatları ve kahvaltı içeriğine dahil olduğu fiyatları değerlendirip fiyat optimizasyonu yapmak istemektedir. Yönetici aynı zamanda tedarikçilerden temin edilen ürünlerin fiyatlarını takip etmek istemektedir. Enflasyon verisini de göz önünde bulundurarak fiyatları şekillendirip kar/zarar oranlarını gözetmek istemektedir.

	2.Dükkan işleyiş itibariyle bir kasiyere ihtiyaç duymamaktadır. Kahvaltı veya perakende müşterileri, hesabı kasanın yanına gelip ödemektedir. POS cihazına bağlı bir sisteme ihtiyaç yoktur, ödemeler bir arayüz vasıtasıyla sisteme elle girilmelidir. Bu arayüz olabildiğince basit olup her kullanıcının rahatlıkla veri girişi yapabileceği şekilde tasarlanmalıdır. Satışlar yapıldıktan sonra sisteme kaydedilmeden önce onay için beklemede kalır, süpervizör tarafından onaylanmadan sisteme kalıcı olarak işlenemez.

	3.Sistemi ölçeklendirilebilir bir yapıda; gerektiğinde yeni modüller eklenebilecek ve daha büyük veri kümelerini yönetebilir hale gelecek şekilde revize edilebilir bir anlayışla kurgulamak.
	Aktörler: 

1.Personel sınıfı
	a.Perakende veya kahvaltı siparişlerini girme yetkisi
	b.Ürün arama, ürünlerin stokta olup olmadığını görüntüleme yetkisi

2.Süpervizör sınıfı
	a.Personel sınıfının yetkilerinin tümü
	b.Sipariş onayı yetkisi
	c.Ürün teslimatlarını onaylama yetkisi
	d.Ürün-tedarikçi ilişkilerinin düzenlenmesi, tedarikçi bilgilerini düzenleme, ürün kalemleri ekleme/çıkartma ve ürün satış fiyatlarını düzenleme yetkileri
	e.Personel bilgilerini düzenleme, personel ekleme ve çıkartma yetkileri

3.Yönetici sınıfı
	a.Personel ve süpervizör sınıflarının yetkilerinin tümü
	b.Aktörleri görüntüleme, ekleme ve düzenleme yetkisi
	c.Günlük, aylık ve yıllık satış raporlarını görüntüleme yetkisi
	d.Bütün gelirleri ve maliyetleri görüntüleme yetkisi
	e.Performans analizleri yapabilme yetkisi

Planlama:

	Kahvaltı satışları: Fiks n-kişilik kahvaltı servislerine ek olarak hesaba portakal suyu, süt, Türk kahvesi gibi yan ürünler de eklenebilmektedir. İskontolar ve yeri geldiğinde ikram edilecek yan ürünler süpervizörün inisiyatifindedir. 

	Perakende satışlar: Dükkanın ürün gamını peynir, zeytin, zeytinyağı, reçel, salça, köy yumurtası vb. ürünler oluşturmaktadır. süpervizörün inisiyatifinde iskontolar yapılabilmektedir. Alış-satış miktarlarının takibi için ürünlerin adetlerinin/gramajlarının ve yapılan iskonto sonucu alınan toplam ücretin sisteme girilmesi gerekmektedir. 

Bu bilgiler ışığında sistemde tasarlanması gereken 4 ana modül vardır.

1.Satış Arayüzü (Personel, Süpervizör, Yönetici)
	Kavhaltı siparişlerinin ve yan ürünlerinin girilmesi ve onaylanması, perakende satışların girilmesi ve onaylanması için kullanıcı dostu bir arayüz sunmayı amaçlamaktadır. Kasanın yanındaki tek bir arayüzden veya her personelin cep telefonundan erişilebilir olması düşünülmektedir.

Kapsam:

	Kahvaltı satışları:
		+Masalardaki kahvaltı sayısının (n-kişilik servis) girilmesi
		+Yan ürünlerin eklenebilmesi.
		+Her servis için iskonto veya süpervizörün inisiyatifinde yapılacak ikramların uygulanabilmesi.

	Perakende satışlar:
		+Ürün seçimi ve miktar girilmesi (adet veya gramaj olarak).
		+İskonto uygulanabilmesi (süpervizörün inisiyatifine bağlı olarak).
		+Veritabanındaki stok miktarlarının güncellenmesi

	Ortak işlevler:
		+Tüm kullanıcılar tarafından kullanılabilir
		+Satış verileri veritabanına işlenmeden önce süpervizör/yöneticilere özel bir panelde onay bekler.

2.İşletme Bilgi Arayüzü (Süpervizör, Yönetici)
	Hem kahvaltı yan ürünlerinin hem de perakende ürünlerin stok durumunu takip etmek, ürünlerin hangi tedarikçilerden hangi fiyatlarda alındığını listeleyerek ürün satış fiyatlarını belirlemek ve kahvaltı menüsünün fiyatını optimize etmek, genel giderleri düzenlemek ve personel yönetimi için bir arayüz sunmayı amaçlamaktadır.

Kapsam:

	+Detaylı sipariş geçmişi görüntüleme (kahvaltı ve perakende satışlar).
	+Perakende ürün gamı düzenleme
		-Stok durumları
		-Güncel alış-satış fiyatları ve fiyat geçmişi
		-Her ürün kalemi için tedarikçi(ler) bilgisi
		-Mevsimsel ürünlerin takibi, ürünlerin satış arayüzündeki görünürlüğü
	+Kahvaltı fiyat optimizasyonu
		-Ürün alış fiyatlarına göre kahvaltı içeriğindeki ürünlerin gramajlarının ayarlanması, bu verilere göre kahvaltı porsiyon satış fiyatı belirlenmesi
		-Kahvaltı menüsünde hangi ürünlerin müşteriler tarafından daha çok tercih edildiğinin takibi, mevsimsel ürünlerin menüye eklenmesi/çıkartılması
	+Tedarikçi bilgilerini düzenleme
		-Hangi tedarikçiden hangi ürünlerin alındığının takibi ve düzenlenmesi
		-Ürün teslimatlarının sisteme işlenmesi, ödeme bilgisi görüntüleme, ekleme, vadesi gelen borçlar için uyarı verme
		-Satış trendlerine göre sipariş önerileri yapma
	+Genel giderleri düzenleme
		-Fatura, kira gibi sabit giderlerin sisteme işlenmesi
	+Personel bilgilerini düzenleme
		-Sabit ve geçici personel havuzunu görüntüleme ve düzenleme
		-Maaş, avans bilgilerini görüntüleme ve düzenleme
		-SGK primlerini takip etme, vadesi gelen ödemeler için uyarı verme


3.Yönetim Araçları (Yönetici)
	İşletmenin genel performansını, maliyet ve ciro analizlerini ve diğer stratejik yönetim işlemlerini desteklemeyi amaçlamaktadır.

Kapsam:

	+Raporlama ve analiz 
		-Günlük, haftalık ve aylık satış raporlarının oluşturulması.
		-Stok raporlarının oluşturulması
		-Grafik ve tablo şeklinde trend analizleri
		-Tedarikçi fiyatları, enflasyon verisi ve kar/zarar oranlarının raporlanması
	+Kullanıcı ve yetki yönetimi
		-Tüm kullanıcıların erişim logları ve yetkilendirme düzenlemelerinin yapılması
	+Stratejik karar destek
		-İşletmenin karlılık durumu, gelecek projeksiyonları

4.Veritabanı Yönetimi
	Tüm işlemlerin güvenli, tutarlı ve performanslı bir şekilde saklanması ve yönetilmesini amaçlamaktadır. Tasarımın bütün diğer modüllerin ihtiyaçlarını karşılayacak şekilde ölçeklenebilir ve dinamik olarak yapılandırılması amaçlanmaktadır.

Kapsam:

	+Kullanıcılar tablosu
		-Kullanıcı kimlik doğrulaması, yetki yönetimi ve erişim loglarının tutulması
		-Personel bilgilerinin tutulması
	+Ürün ve envanter yönetimi
		-Hem kahvaltıda kullanılan yan ürünler hem de perakende ürünlerin temel bilgilerini saklamak ve işlem kayıtlarını tutmak
	+Satış işlemleri
		-Kahvaltı (ve yan ürünlerinin) ve perakende satışların temel bilgilerini saklamak
		-Varsa iskonto bilgilerini saklamak
	+Tedarikçi ve fiyat yönetimi
		-Ürün tedarikçileriyle ilgili bilgileri yönetmek
		-Ürün tedarik ve satış fiyatlarındaki değişiklikleri takip etmek
	+Gider yönetimi
		-Fatura, kira vb. giderlerin bilgilerini saklamak
		-Personel maaşlarını saklamak
	+Gelir yönetimi
		-Nakit gelirlerin takibi
		-Kredi kartı satışları sonucu bankadan gelen paranın takibi
	+İşlem ve onay kayıtları
		-Personel tarafından girilen verilerin süpervizör onay sürecini kaydetmek
		-Bütün diğer kritik işlemlerin kaydını tutmak

5. Proje Gereklilikleri:

	+Yabancı anahtar ilişkilerinin doğru bir şekilde tanımlanıp veri tutarlılığını sağlamak 
	+Gerekli verilere indekslemeler oluşturarak sistem verimini artırmak
	+Rol tabanlı erişim kontrolü
	+İnternet bağlantısı olmadığında verilerin geçici olarak saklanması, sistem online olduğunda verilerin merkezi veritabanıyla senkronize edilmesi için gereken mekanizmalar
	+Raporlama ihtiyaçları için günlük, haftalık, aylık satış verilerini toparlayacak fonksiyonlar



VERİTABANI ve CRUD ALTYAPISI DURUM RAPORU (27.04.2025)

	Amaç:
		Projenin ilk aşamasında, veri modeli ve temel CRUD işlemleri güvenli ve sürdürülebilir olacak şekilde kurgulanmış; ileride frontend arayüzü üzerinden yapılacak girişler için altyapı hazırlanmıştır. Veri depolaması için SQL Server (SSMS) kullanımı hedeflenmiş ve şema buna uygun olarak geliştirilmiştir.

	Veritabanı Tasarımı

	Genel Yapı:

		Veritabanı, normalize edilmiş yapıya sahip olup aşağıdaki temel tablolar oluşturulmuştur:

			Birimler, UrunKategorileri, AltKategoriler, Urunler, Tedarikciler, TedarikciAltKategori, UrunTedarikci (alış fiyatları + tarih bilgisi), Envanter, GecmisFiyatlar, Satislar (perakende ve kahvaltı satışları)

	Tasarım Notları:

		Tüm tablolar FK ilişkileriyle bağlanmış ve veri bütünlüğü korunmuştur.

		Envanter tablosu, her ürün için mevcut miktarı ve birimini tutar.

		GecmisFiyatlar ile ürün fiyatları zaman içinde izlenebilir hale getirilmiştir.

		Kahvaltı ve perakende satışlar aynı Satislar tablosunda farklı işlem türüyle ayrıştırılmak üzere yapılandırılmıştır.

		UrunTedarikci tablosunda ürün başına birden fazla tedarikçi tanımlanabilir.

	Spring Boot Altyapısı

		Temel Yapılandırma:

			Spring Boot 3.x ile yapılandırılmıştır.

			Maven kullanılarak bağımlılıklar yönetilmektedir.

			application.properties dosyasında SSMS bağlantısı konfigüre edilmiştir.

		Katmanlı Mimari:

			src/
				core/           → Servis katmanı (iş mantığı)
				data/           → Entity ve Repository sınıfları
				api/            → Controller katmanı

		Kullanılan Spring Bileşenleri:

			@Entity, @Table: ORM eşlemeleri

			@Repository: CRUD işlemleri için JpaRepository tanımları

			@Service: Mantıksal iş akışları

			@RestController: API endpoint tanımları

		Örnek CRUD Akışı (SatisService üzerinden):

			@Service
			public class SatisService {
				private final SatisRepository repository;

				public SatisService(SatisRepository repository) {
					this.repository = repository;
				}

				public Satis create(Satis satis) {
					return repository.save(satis);
				}

				public List<Satis> getByUrunID(Long urunID) {
					return repository.findByUrunID(urunID);
				}
			}


Uygulama Durumu ve Devam Planı

	Şu Ana Kadar Yapılanlar:

		SQL Server uyumlu veri modeli oluşturuldu.

		Spring Boot içinde bu modelin birebir karşılığı olan Entity sınıfları yazıldı.

		Repository, Service, Controller sınıfları tanımlandı.

		GET, POST, DELETE işlemleri çalışan örnekler üzerinden test edildi.

		Satis tablosunda ürün ID’ye göre filtreleme yapılabilecek servis ve repository yazıldı.

	Bir Sonraki Aşama:

		Frontend üzerinden veri girişi sağlayacak formlar hazırlanacak.

		Veritabanı veri güvenliği ve tutarlılığı için kısıtlar oluşturulacak.

		Girişlerin geçici olarak bekletilip süpervizör onayı ile veritabanına yazılması sağlanacak.

		Rol bazlı erişim ve kullanıcı oturumu yönetimi eklenecek.

