Generate private key: 
```
openssl genrsa -out private_key.pem 2048
```

Convert private key to pkcs8 format in order to import it from Java:
```
openssl pkcs8 -topk8 -in private.pem -inform pem -out private_pkcs8.pem -outform pem -nocrypt
```