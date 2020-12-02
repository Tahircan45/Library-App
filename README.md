# Library-App
**Uygulamanın Kurulması ve Çalıştırılması**
Uygulama Github üzerinden bilgisayarımıza indirdikten sonra Maven ile bir "*executable jar*" dosyası oluşturup bu dosyayı çalıştırabiliriz. Bunun için öncelikle terminal ile proje klasörünün içindeyken `mvn package` komutunu çalıştırıyoruz. Daha sonra oluşan `target` klasörüne girip `java -jar Library-App-0.0.1-SNAPSHOT.jar` komutu ile jar dosyamızı çalıştırabiliriz. Uygulamaya bağlanmak için `http://localhost:8080/` adresini kullanabiliriz.Sisteme giriş için gerekli kullanıcı adı ve şifre bilgilere aşağıdaki **Yetkilendirme ve Kimliklendirme** kısmında verilmiştir.
**Uygulamanın İşlevleri**

 1. Yeni yazar ekleme
 2. Yeni yayınevi ekleme
 3. Yeni kitap ekleme ve düzenleme
 4. Kitaplar ile yayınevi ve yazarlar arasında ilişki kurabilme
 5. Kitap kayıtlarını silebilme

**Kullanılan Teknolojiler**

 6. Spring Web (Yönlendirmelerin ve İsteklerin yerine getirilmesi)
 7. Spring Security (Yetkilendirme ve Kimliklendirme)
 8. Spring Data JPA (Veri tabanı işlemleri)
 9. H2 Database (Projenin yerel bir veri tabanına bağımlı olmaması için gömülü veri tabanı)
 10. Thymeleaf (Görünüm katmanı)

**Yetkilendirme ve Kimliklendirme**
Bu uygulama için 3 adet rol tanımlanmıştır ve veri tabanına varsayılan olarak 3 tane kullanıcı eklenerek rolleri tanımlanmıştır. Tanımlı roller ve yetkileri aşağıdaki listede verilmiştir.

 1.User: **Kitapları listeleme**, **arama yapma** ve **detayları görüntüleme**.
 2.Admin: User rolüne ek olarak **yeni kitap** ,**yeni yazar**, **yeni yayınevi ekleme** ve **kitapları düzenleme**.
 3.Manager: Admin rolüne ek olarak  var olan **kayıtları silme**

Roller ve kayıtlı kullanıcılar
| Rol | User | Admin |Manager|
|--|--|--|--|
| Kullanıcı Adı |  user1| admin |manager|
| Şifre |  user1| admin |manager|



