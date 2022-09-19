#!/bin/bash
ant clean
N=$(git rev-list --count HEAD master )
for (( counter = 1; counter <= $N; counter++ ));
do
  ARG="$counter""p"
  COMMIT_HASH=$(git log | grep "commit " | head -$N | awk '{print $2}' | sed -n $ARG)
  git checkout "$COMMIT_HASH"
  git checkout master build.xml
  git checkout master temps.properties
  ant build &
  pid=$!
  wait $pid
  stat=$?

  if [ $stat -eq 0 ]
  then
    echo "BUILD SUCCESSFUL OF COMMIT: " "$COMMIT_HASH"
    touch file
    ((N = N + 1))
    ((counter = counter + 1))
    ARG1="$counter""p"
    COMMIT_HASH_NEXT=$(git log | grep "commit " | head -$N | awk '{print $2}' | sed -n $ARG1)
    echo "NEXT COMMIT HASH IS: " "$COMMIT_HASH_NEXT"
    git diff "$COMMIT_HASH" "$COMMIT_HASH_NEXT" > file
    break
  else
    echo "CHECKOUT NEXT COMMIT"
  fi
done

git checkout master