# Biometric-Authentication-JAVA
The objective of this software is to develop a biometric identification and authentication system, and to study image processing techniques to identify and make comparisons.

NetBeans IDE 8.2 and SQLiteStudio v3.2.1 a biometric reader Usb Digital Persona Mod were used. U Are U 4000b.

![D_NQ_NP_837634-MLB42862701173_072020-W](https://user-images.githubusercontent.com/80012970/168698060-abe08e68-7ee6-47ff-a88b-420e1221a060.jpg)

Login screen with registration option at the top.

![Imagem1](https://user-images.githubusercontent.com/80012970/168694203-10dbbf83-d0ee-4754-9975-32926310cf24.png)

Registration screen with name, password and position hierarchy.

![Imagem2](https://user-images.githubusercontent.com/80012970/168694340-c57cf562-3581-423f-95f7-0f6d4c51d3d8.png)

After registering the previous information, you will ask to register the fingerprint.

![Imagem3](https://user-images.githubusercontent.com/80012970/168694771-e8b990ca-5701-4b22-a4e2-5ef8546ace1d.png)

Person who is going to register the fingerprint will need to enter it 4 times to record it in the database.

![Imagem4](https://user-images.githubusercontent.com/80012970/168696129-5c175562-f3ab-43ed-967f-592b1084905a.png)

After saving the registration, it will return to the previous screen with the user already registered in the side table.

![Imagem5](https://user-images.githubusercontent.com/80012970/168696580-0699bf00-bddb-4c15-a3e1-6a60aea8a910.png)

The program's database has 5 tables Idusuario, nome, senha, hierarquia, digital.

![Imagem6](https://user-images.githubusercontent.com/80012970/168696757-e7c816e3-9c9a-4ea0-9d19-4b8b9f0d5f33.png)

Idusuario is a unique number for each registration, username, password it is encrypted, hierarchy and the person level and the fingerprint uses the BLOB type which is a field to use binary information.

![Imagem7](https://user-images.githubusercontent.com/80012970/168696952-bb448fdc-2236-4f45-9c70-ebae26975353.png)

Fingerprint table data, BLOB type.

![Imagem8](https://user-images.githubusercontent.com/80012970/168697214-7e2f8825-7116-46e8-99d6-23cd2e787937.png)

Login screen when entering correct name and password will ask to enter fingerprint.

![Imagem9](https://user-images.githubusercontent.com/80012970/168697342-2ff5909a-528a-41f6-9e8c-2f8914c672cc.png)

After putting the right username and password will ask to put your finger.

![Imagem10](https://user-images.githubusercontent.com/80012970/168697624-b40e35cf-e20e-4bb1-923e-7e71a9678d52.png)

After entering the fingerprint and it corresponds with the database.

![Imagem11](https://user-images.githubusercontent.com/80012970/168697702-499beaa2-3bcf-4401-a5de-ac7426ed0d93.png)

