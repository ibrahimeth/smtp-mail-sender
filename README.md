# smtp-mail-sender
SMTP ile Mail gönderim işlemi Google nin smtp.gmail.com adlı serverine bağlanıyoruz ve bazı protoköllerce işlemlerimizi gerçekleştiriyoruz. Smtp için en bilinden iki adet port mevcut bunlar 587 ve 465 ben 465. Portu kullandım çünkü bu port SSL ile korunuyor. Programın çalışması için <YOUR-ENCODED-EMAIL-WITH-Base64> ve <YOUR-ENCODED-PASSWORD-WITH-Base64> satırlarını kendinize göre değiştirmelisiniz unutmayınız <> tagları olmamamlı Ayrıca MAIL FROM: <YOUR EMAIL> buraya <> işaretleri olmak üzere kendi gönderen mailinizi yazınız.
Dikkat:
Kendi Mail şifrenizi kullanmayacaksınız.Bunun için 

https://myaccount.google.com/ adresine gidin
Sol menüde "Güvenlik" butonuna tıklayın
"Google'da oturum açma" bölümünde "2 Adımlı Doğrulama" seçeneğine tıklayın.
Burada tekrar mail adresi ve parola istenebilir.
Altta "Uygulama şifreleri" bölümüne gelip tıklayın.
Uygulamanıza bir isim verin "Sending mails over sockets using SMTP"
"Oluştur" butonua tıklayın.
Ekrana gelen şifreyi, Java uygulamalarınız içerisinde kullanabilirsiniz. (base64 ile encode ettikten sonra)