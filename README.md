# EWDJ_examenopdracht_IT_conferentie

## ERD
[built with krokio](
https://kroki.io/erd/svg/eNptT7sOgzAM3P0VmVNl4BdadUDq1nZCVRUSq4RXUBL4_oYYCkhdrPPd2WcX1wn78AJuNJxa20jZ5hGVKDt0EfVSdqBlGLuHqTWU6FXlTD2Z_gNDBB6guA8OG3S0ZLLWpaFUoLilnaQlSslBKhPQhKieUw6plHmxGldYoWqi6elXi7PtlvdeT_fUx2s5zlSu2TL1s4z-oAPQWSwTgrNkglSJOATA0v2TaIYLkTH6BOZUcm75-9U7Fr6xenzl)

### Used syntax

[Event]  
*id  
+lokaalId  
+beamerId  
naam  
datumTijd  
beschrijving  
prijs  

[Spreker]  
*id  
voornaam  
naam  

[Lokaal]  
*id  
naam  
capaciteit  

[Beamer]  
*id  
beamerCode  
beamerCheck  

[User]  
*id  
rol  

[Spreker_Event]  
*sprekerId  
*eventId  

[User_Event]  
*userId  
*eventId  

Lokaal 1--* Event  
Event 1--* Spreker_Event  
Spreker 1--* Spreker_Event  
Event *--1 Beamer  
User 1--* User_Event  
Event 1--* User_Event  

