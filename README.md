# Library-App
**Uygulamanın Kurulması ve Çalıştırılması**

Uygulama Github üzerinden bilgisayarımıza indirdikten sonra Maven ile bir "*executable jar*" dosyası oluşturup bu dosyayı çalıştırabiliriz. Bunun için öncelikle terminal ile proje klasörünün içindeyken `mvn package` komutunu çalıştırıyoruz. Daha sonra oluşan `target` klasörüne girip `java -jar Library-App-0.0.1-SNAPSHOT.jar` komutu ile jar dosyamızı çalıştırabiliriz. Uygulamaya bağlanmak için `http://localhost:8080/` adresini kullanabiliriz.Sisteme giriş için gerekli kullanıcı adı ve şifre bilgilere aşağıdaki **Yetkilendirme ve Kimliklendirme** kısmında verilmiştir.

**Yetkilendirme ve Kimliklendirme**

Bu uygulama için 3 adet rol tanımlanmıştır ve veri tabanına varsayılan olarak 3 tane kullanıcı eklenerek rolleri tanımlanmıştır. Tanımlı roller ve yetkileri aşağıdaki listede verilmiştir.

 1. User: **Kitapları listeleme**, **arama yapma** ve **detayları görüntüleme**.
 2. Admin: User rolüne ek olarak **yeni kitap** ,**yeni yazar**, **yeni yayınevi ekleme** ve **kitapları düzenleme**.
 3. Manager: Admin rolüne ek olarak  var olan **kayıtları silme**

Roller ve kayıtlı kullanıcılar

| Rol | User | Admin |Manager|
|--|--|--|--|
| Kullanıcı Adı |  user1| admin |manager|
| Şifre |  user1| admin |manager|


**Uygulamanın İşlevleri**

 1. Yeni yazar ekleme
 2. Yeni yayınevi ekleme
 3. Yeni kitap ekleme ve düzenleme
 4. Kitaplar ile yayınevi ve yazarlar arasında ilişki kurabilme
 5. Kitap kayıtlarını silebilme

**Kullanılan Teknolojiler**

 1. Spring Web (Yönlendirmelerin ve İsteklerin yerine getirilmesi)
 2. Spring Security (Yetkilendirme ve Kimliklendirme)
 3. Spring Data JPA (Veri tabanı işlemleri)
 4. H2 Database (Projenin yerel bir veri tabanına bağımlı olmaması için gömülü veri tabanı)
 5. Thymeleaf (Görünüm katmanı)

![Anasayfa](https://i.ibb.co/DL6Jt1R/Library-App-img.jpg" )













