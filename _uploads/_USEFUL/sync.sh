set old_pwd=$PWD
eval $(ssh-agent)
trap "ssh-agent -k" exit
ssh-add ~/.ssh/id_rsa
mkdir ~/_sam_temp
cd ~/_sam_temp
git clone --mirror ssh://eynorey@eynorey.visualstudio.com:22/SAM%20-%20Smartify%20The%20World/_git/sam-private
cd sam-private.git
git remote add new-origin git@github.com:Eynorey/SAM.git
git push new-origin --mirror
git remote rm new-origin
cd $old_pwd
unset old_pwd
rm -R ~/_sam_temp
