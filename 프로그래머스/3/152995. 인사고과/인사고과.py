def solution(scores):
    wanho = scores[0]
    wanho_total = sum(wanho)

    # 100,000*100,000 하면 무조건 시간초과
    # 첫 번째 점수 내림차순
    # 첫 번째 점수가 같으면 두 번째 점수 오름차순
    scores.sort(key=lambda x: (-x[0], x[1]))

    max_second_score = -1
    answer = 1

    for first_score, second_score in scores:

        # 앞에 두 점수가 모두 높은 사원이 존재함
        if second_score < max_second_score:
            # 완호가 인센티브 제외 대상
            if [first_score, second_score] == wanho:
                return -1

            continue

        max_second_score = max(
            max_second_score,
            second_score
        )

        # 완호보다 합계 점수가 높은 인센티브 대상
        if first_score + second_score > wanho_total:
            answer += 1

    return answer