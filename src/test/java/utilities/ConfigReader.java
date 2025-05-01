package utilities;

import java.io.FileInputStream; // Dosya okuma işlemleri için gerekli kütüphane
import java.io.IOException; // Dosya okuma sırasında hata yönetimi için
import java.util.Properties; // Properties dosyasını yönetmek için kullanılır

/**
 * ConfigReader sınıfı, config.properties dosyasından anahtar-değer çiftlerini okuyarak
 * uygulamanın çeşitli ayarlarını dinamik olarak yüklemeyi sağlar.
 */
public class ConfigReader {
    // Properties nesnesi, config.properties içindeki değerleri saklamak için kullanılır
    private static Properties properties;

    // **Statik blok**: Sınıf ilk kez çağrıldığında çalışır ve config dosyasını yükler
    static {
        try {
            // config.properties dosyasını okuma işlemi
            FileInputStream file = new FileInputStream("config.properties");

            // Properties nesnesini oluştur ve dosyayı yükle
            properties = new Properties();
            properties.load(file);

            // Dosyayı kapat (kaynak yönetimi için önemli)
            file.close();
        } catch (IOException e) {
            // Hata oluşursa istisnayı (exception) ekrana yazdır
            e.printStackTrace();
        }
    }

    /**
     * Config dosyasından belirli bir anahtarı alıp, ilgili değeri döndüren metod
     *
     * @param key config.properties içinde tanımlı anahtar
     * @return Anahtara karşılık gelen değer
     */
    public static String getProperty(String key) {
        return properties.getProperty(key); // Anahtarın değerini döndür
    }
}
