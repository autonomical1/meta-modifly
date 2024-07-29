# Information

This is where the entirety of the build process of the ModiflyPlatform takes place.

## Additional setup required to configure install from private directory

Because `ModiflyPlatform` is a private git repository, the build system will not be able to access it without user credentials. 

### Git credentialing
To set up Git credentials on a Linux system, follow these steps:

Create a `config` file in `~/.ssh/`
```
nano ~/.ssh/config
```

Paste this into that file:

```
Host github.com
  HostName github.com
  PreferredAuthentications publickey
  IdentityFile ~/.ssh/id_ed25519
```

Now, generate an SSH key to authenticate yourself with GitHub.
```
ssh-keygen -t ed25519
```

Navigate to the `.ssh` directory and print the public SSH key.
```
cat ~/.ssh/id_ed25519.pub
```

Copy the result and navigate to (https://github.com/settings/ssh/new). Give the SSH Key a name and add it to your account. 

To test if the key works, execute this command in the terminal: 
```
ssh -T git@github.com
```

If it gives you a "Succesfully Authenticated" message, the fetch process will work. If not, then something went wrong, and you should try again to find the issue. 

## ModiflyPlatform

The `gitsm://` fetcher retrieves both the source git repository, as well as all of the libraries linked as submodules. This can throw warnings because the `.gitmodules` file is formatted in a way that Yocto doesn't really like. 

The recipe file contains all of the dependencies, configuration scripts, patches, and other required pieces of information. At the current moment, cross compilation will not work due to an inherent issue with how Yocto handles different sets of header files. 