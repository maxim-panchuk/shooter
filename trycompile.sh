
#ARG="2""p"
#git log | grep commit | head -2 | awk '{print $2}' | sed -n $ARG

git log | grep commit | awk '{print $2}'