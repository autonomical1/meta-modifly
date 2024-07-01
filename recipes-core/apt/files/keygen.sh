#!/bin/bash

gpg --keyserver keyserver.ubuntu.com --recv-keys 0E98404D386FA1D9
gpg --export  0E98404D386FA1D9 | sudo tee key1.gpg

gpg --keyserver keyserver.ubuntu.com --recv-keys  6ED0E7B82643E131
gpg --export   6ED0E7B82643E131| sudo tee key2.gpg

gpg --keyserver keyserver.ubuntu.com --recv-keys F8D2585B8783D481
gpg --export  F8D2585B8783D481| sudo tee key3.gpg

gpg --keyserver keyserver.ubuntu.com --recv-keys 54404762BBB6E853
gpg --export  54404762BBB6E853| sudo tee key4.gpg

gpg --keyserver keyserver.ubuntu.com --recv-keys  BDE6D2B9216EC7A8
gpg --export   BDE6D2B9216EC7A8| sudo tee key5.gpg

gpg --keyserver keyserver.ubuntu.com --recv-keys  C0BA5CE6DC6315A3
gpg --export  C0BA5CE6DC6315A3 | sudo tee key6.gpg

