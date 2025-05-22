# SSL DEV INSTRUCTIONS
Modifly now uses SSL to secure the connection between the client and the server. This is done using a self-signed certificate. The certificate is generated using the OpenSSL toolkit. The certificate is stored in the `pki` directory. The modifly-dev-rootca.pem file is the root certificate authority. It will only work in development environments and only allows certificates with the 'localhost' FQDN. 
Addtionally, there are modifly-dev-localhost.crt and modifly-dev-localhost.key files. These are the certificate and key files for the localhost server. The certificate is signed by the root certificate authority. They only work on localhost connections and with controllers that are named 'modifly-utsa-dev'.

At this time, verification is `disabled.` This means that the client will not verify the server's certificate. This is done to allow for easier development. Soon, this will be `enabled` and the client will verify the server's certificate.

## To use:
Copy these files in the bin directory of the build and then edit the configuration files for the platform, cockpit, and the controller to contain the following:

### platform / cockpit.toml
Insert the following lines in your configuration files. If you fail to do so, you will get errors thrown during the SSL startup process.
```toml
[ssl]
add_root_ca = true
root_ca = "../../pki/modifly-dev-rootca.pem"
```

### controller.toml

```toml
[ssl]
certificate = "../../pki/modifly-dev.localhost.crt"
private_key = "../../pki/modifly-dev.localhost.key"
add_root_ca = true
root_ca = "../../pki/modifly-dev-rootca.pem"
```