from collections import deque


def solution(bridge_length, weight, truck_weights):
    bridge = deque()
    truck = deque()
    arrived = []
    time = 0
    current_weight = 0
    truck.extend(truck_weights)
    bridge.extend([0 for _ in range(bridge_length)])
    
    # bridge에 0을 넣거나 트럭을 보내거나 (건너지 않은 트럭이 있는 경우)
    # bridge에 아무것도 보내지 않는다 (건너지 않은 트억이 없는 경우)
    while len(bridge) > 0:
        if len(truck) >= 1:
            box = truck.popleft()
            if (current_weight-bridge[0])+box <= weight:
                tmp = bridge.popleft()
                arrived.append(tmp)
                bridge.append(box)
                current_weight += box
                current_weight -= tmp
            else:
                tmp = bridge.popleft()
                arrived.append(tmp)
                bridge.append(0)
                truck.appendleft(box)
                current_weight -= tmp
        else:
            arrived.append(bridge.popleft())
        time += 1
    
    return time
