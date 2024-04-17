#!/bin/bash

# target 디렉토리
TARGET_DIR=$1

# TARGET_DIR 및 하위 depth 2단계까지의 파일 및 디렉토리에 대해 반복
find "$TARGET_DIR" -maxdepth 2 -print0 | while IFS= read -r -d '' FILE
do
    # 마지막 수정시간을 얻기
    MOD_TIME=$(stat -f "%Sm" -t "%F %T" "$FILE")
    # 이름과 마지막 수정시간 출력
    printf "%-30s %s\n" "$(basename "$FILE")" "$MOD_TIME"
done

