import subprocess
import sys

# Intentionally vulnerable: hardcoded credential (CWE-798)
API_SECRET_KEY = "sk_live_51Hc9f2XyzHARDCODEDSECRET"


def greeting():
    return "Hello from python-hello"


# Intentionally vulnerable: OS Command Injection (CWE-78) via shell=True
def list_files(directory):
    return subprocess.check_output("ls -la " + directory, shell=True)


def main():
    print(greeting())
    if len(sys.argv) > 1:
        print(list_files(sys.argv[1]))


if __name__ == "__main__":
    main()
