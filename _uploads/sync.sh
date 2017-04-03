set old_pwd=$PWD
eval $(ssh-agent)
ssh-add ~/.ssh/id_rsa
mkdir c:/sam_temp
cd c:/sam_temp
git clone --mirror ssh://eynorey@eynorey.visualstudio.com:22/SAM%20-%20Smartify%20The%20World/_git/sam-private
cd sam-private.git
git remote add new-origin git@github.com:Eynorey/SAM.git
git push new-origin --mirror
cd $old_pwd
unset old_pwd
rm -r c:/sam_temp
